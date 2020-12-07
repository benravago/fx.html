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
* proper attribute node was retrieved.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D095">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D095</a>
*/
class Get_Attribute_Node_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getAttributeNodeNS02")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  Attr attribute;
  String attrName;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = (Element) elementList.item(0);
  assertNotNull(testAddr, "empAddrNotNull");
  attribute = testAddr.getAttributeNodeNS("http://www.nist.gov", "domestic");
  attrName = attribute.getNodeName();
  assertEquals("emp:domestic", attrName, "attrName");
 }
}