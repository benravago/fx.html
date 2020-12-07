package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNamedItemNS(namespaceURI,localName)" method for a 
* NamedNodeMap should return a node specified by localName and namespaceURI 
* 
* Retrieve a list of elements with tag name "address".
* Access the second element from the list and get its attributes.
* Try to retrieve the attribute node with local name "domestic"
* and namespace uri "http://www.usa.com" with
* method getNamedItemNS(namespaceURI,localName).
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D095">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D095</a>
*/
class Get_NamedItem_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getNamedItemNS01")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  NamedNodeMap attributes;
  Attr domesticAttr;
  String attrName;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("address");
  testEmployee = elementList.item(1);
  attributes = testEmployee.getAttributes();
  domesticAttr = (Attr) attributes.getNamedItemNS("http://www.usa.com", "domestic");
  attrName = domesticAttr.getNodeName();
  assertEquals("dmstc:domestic", attrName, "attrName");
 }
}