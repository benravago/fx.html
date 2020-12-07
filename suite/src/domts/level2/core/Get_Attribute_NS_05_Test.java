package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributeNS(namespaceURI,localName)" method retrieves an
* attribute value by local name and NamespaceURI.
* 
* Retrieve the first emp:address element node 
* and retrieve the emp:domestic attribute.  The method returns an
* Attr value as a string, the "value" can be examined to ensure the
* proper attribute value was retrieved.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS</a>
*/
class Get_Attribute_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getAttributeNS05")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  String attrValue;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = (Element) elementList.item(0);
  assertNotNull(testAddr, "empAddrNotNull");
  attrValue = testAddr.getAttributeNS("http://www.nist.gov", "domestic");
  assertEquals("Yes", attrValue, "attrValue");
 }
}