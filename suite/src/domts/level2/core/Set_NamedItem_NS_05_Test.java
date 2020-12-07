package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setNamedItemNS(arg)" method for a 
* NamedNodeMap should replace an existing node n1 found in the map with arg if n1
* has the same namespaceURI and localName as arg and return n1.
* 
* Create an attribute node in with namespaceURI "http://www.usa.com"
* and qualifiedName "dmstc:domestic" whose value is "newVal".
* Invoke method setNamedItemNS(arg) on the map of the first "address"
* element. Method should return the old attribute node identified
* by namespaceURI and qualifiedName from above,whose value is "Yes".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
*/
class Set_NamedItem_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setNamedItemNS05")
 void run() throws Throwable {
  String namespaceURI = "http://www.usa.com";
  String qualifiedName = "dmstc:domestic";
  Document doc;
  Node arg;
  NodeList elementList;
  Node testAddress;
  NamedNodeMap attributes;
  Node retnode;
  String value;
  doc = (Document) load("staffNS", true);
  arg = doc.createAttributeNS(namespaceURI, qualifiedName);
  arg.setNodeValue("newValue");
  elementList = doc.getElementsByTagName("address");
  testAddress = elementList.item(0);
  attributes = testAddress.getAttributes();
  retnode = attributes.setNamedItemNS(arg);
  value = retnode.getNodeValue();
  assertEquals("Yes", value, "throw_Equals");
 }
}