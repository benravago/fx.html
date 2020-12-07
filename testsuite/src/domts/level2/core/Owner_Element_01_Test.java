package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getOwnerElement()" will return the Element node this attribute
* is attached to or null if this attribute is not in use.  
* Get the "domestic" attribute from the first "address" node.
* Apply the "getOwnerElement()" method to get the Element associated 
* with the attribute.  The value returned should be "address".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D095">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D095</a>
*/
class Owner_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/ownerElement01")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testNode;
  NamedNodeMap attributes;
  Attr domesticAttr;
  Element elementNode;
  String name;
  doc = (Document) load("staff", false);
  addressList = doc.getElementsByTagName("address");
  testNode = addressList.item(0);
  attributes = testNode.getAttributes();
  domesticAttr = (Attr) attributes.getNamedItem("domestic");
  elementNode = domesticAttr.getOwnerElement();
  name = elementNode.getNodeName();
  assertEquals("address", name, "throw_Equals");
 }
}