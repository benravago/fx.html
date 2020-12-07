package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "hasAttributeNS()" method for an Element should 
* return true if the attribute with the given local name 
* and namespace URI has a default value.
* Retrieve the first "emp:address" element.
* The boolean value returned by the "hasAttributeNS()" should be true 
* since the attribute has a default value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttrNS</a>
*/
class Has_Attribute_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/hasAttributeNS04")
 void run() throws Throwable {
  String localName = "district";
  String namespaceURI = "http://www.nist.gov";
  Document doc;
  NodeList elementList;
  Element testNode;
  boolean state;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("emp:address");
  testNode = (Element) elementList.item(0);
  assertNotNull(testNode, "empAddressNotNull");
  state = testNode.hasAttributeNS(namespaceURI, localName);
  assertTrue(state, "hasAttribute");
 }
}