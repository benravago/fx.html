package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributeNodeNS(namespaceURI,localName)" method retrieves an
* attribute node by local name and NamespaceURI.
* 
* Retrieve the first emp:address element node. 
* The getAttributeNodeNS method returns an
* Attr node, the "value" can be examined to ensure the
* proper attribute node was retrieved.  This attribute
* value should be null since there is no such attribute.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAtNodeNS</a>
*/
class Get_Attribute_Node_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getAttributeNodeNS01")
 void run() throws Throwable {
  String namespaceURI = "http://www.nist.gov";
  String localName = "invalidlocalname";
  Document doc;
  NodeList elementList;
  Element testAddr;
  Attr attribute;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = (Element) elementList.item(0);
  assertNotNull(testAddr, "empAddrNotNull");
  attribute = testAddr.getAttributeNodeNS(namespaceURI, localName);
  assertNull(attribute, "throw_Null");
 }
}