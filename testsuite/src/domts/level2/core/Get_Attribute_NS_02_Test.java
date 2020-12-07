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
* Create a new attribute with the "createAttributeNS()" method.
* Add the new attribute with the "setAttributeNS()" method.
* The value returned by the "getAttributeNS()" method should be the 
* empty string since the attribute does not have a default value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS</a>
*/
class Get_Attribute_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getAttributeNS02")
 void run() throws Throwable {
  String namespaceURI = "http://www.nist.gov";
  String localName = "district";
  String qualifiedName = "emp:district";
  Document doc;
  Attr newAttribute;
  NodeList elementList;
  Element testAddr;
  Attr districtAttr;
  String attrValue;
  doc = (Document) load("staffNS", true);
  newAttribute = doc.createAttributeNS(namespaceURI, qualifiedName);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = (Element) elementList.item(0);
  assertNotNull(testAddr, "empAddrNotNull");
  districtAttr = testAddr.setAttributeNodeNS(newAttribute);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = (Element) elementList.item(0);
  attrValue = testAddr.getAttributeNS(namespaceURI, localName);
  assertEquals("", attrValue, "throw_Equals");
 }
}