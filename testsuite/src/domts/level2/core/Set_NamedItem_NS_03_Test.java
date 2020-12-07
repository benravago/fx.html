package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setNamedItemNS(arg)" method for a 
* NamedNodeMap should add a node using its namespaceURI and localName given that
* there is no existing node with the same namespaceURI and localName in the map.
* 
* Create an attr node with namespaceURI "http://www.nist.gov",qualifiedName
* "prefix:newAttr" and value "newValue".
* Invoke method setNamedItemNS(arg) on the map of the first "address"
* element where arg is identified by the namespaceURI and qualifiedName
* from above.  Method should return the newly added attr node.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D080">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D080</a>
*/
class Set_NamedItem_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setNamedItemNS03")
 void run() throws Throwable {
  String namespaceURI = "http://www.nist.gov";
  String qualifiedName = "prefix:newAttr";
  Document doc;
  Node arg;
  NodeList elementList;
  Node testAddress;
  NamedNodeMap attributes;
  Node retnode;
  String value;
  Node setNode;
  doc = (Document) load("staffNS", true);
  arg = doc.createAttributeNS(namespaceURI, qualifiedName);
  arg.setNodeValue("newValue");
  elementList = doc.getElementsByTagName("address");
  testAddress = elementList.item(0);
  attributes = testAddress.getAttributes();
  setNode = attributes.setNamedItemNS(arg);
  retnode = attributes.getNamedItemNS(namespaceURI, "newAttr");
  value = retnode.getNodeValue();
  assertEquals("newValue", value, "throw_Equals");
 }
}