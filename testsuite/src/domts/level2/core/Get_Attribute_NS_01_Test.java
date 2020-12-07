package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributeNS(namespaceURI,localName)" method retrieves an
* attribute value by local name and NamespaceURI.
* 
* Retrieve the first "emp:address" element.
* The value returned by the "getAttributeNS()" method should be the 
* value "DISTRICT" since the attribute has a default value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=238">http://www.w3.org/Bugs/Public/show_bug.cgi?id=238</a>
*/
class Get_Attribute_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getAttributeNS01")
 void run() throws Throwable {
  String namespaceURI = "http://www.nist.gov";
  String localName = "district";
  String qualifiedName = "emp:district";
  Document doc;
  NodeList elementList;
  Element testAddr;
  String attrValue;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = (Element) elementList.item(0);
  attrValue = testAddr.getAttributeNS(namespaceURI, localName);
  assertEquals("DISTRICT", attrValue, "attrValue");
 }
}