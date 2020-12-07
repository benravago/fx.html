package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNodeNS(newAttr)" adds a new attribute.
* If an attribute with that local name and that namespaceURI is already
* present in the element, it is replaced by the new one.
* 
* Retrieve the first emp:address element and add a new attribute
* to the element.  Since an attribute with the same local name
* and namespaceURI as the newly created attribute does not exist
* the value "null" is returned.
* This test uses the "createAttributeNS(namespaceURI,localName)
* method from the Document interface to create the new attribute to add.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
*/
class Set_Attribute_Node_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setAttributeNodeNS03")
 void run() throws Throwable {
  String namespaceURI = "http://www.newattr.com";
  String qualifiedName = "emp:newAttr";
  Document doc;
  NodeList elementList;
  Node testAddr;
  Attr newAttr;
  Attr newAddrAttr;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = elementList.item(0);
  assertNotNull(testAddr, "empAddrNotNull");
  newAttr = doc.createAttributeNS(namespaceURI, qualifiedName);
  newAddrAttr = ((Element) /*Node */testAddr).setAttributeNodeNS(newAttr);
  assertNull(newAddrAttr, "throw_Null");
 }
}