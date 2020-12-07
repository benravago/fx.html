package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "hasAttributeNS()" method for an Element should 
* return false if the element does not have an attribute with the given local name 
* and/or namespace URI specified on this element or does not have a default value.
* Retrieve the first "emp:address" element.
* The boolean value returned by the "hasAttributeNS()" should be false 
* since the attribute does not have a default value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttrNS</a>
*/
class Has_Attribute_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/hasAttributeNS03")
 void run() throws Throwable {
  String localName = "blank";
  String namespaceURI = "http://www.nist.gov";
  Document doc;
  NodeList elementList;
  Element testNode;
  boolean state;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("emp:address");
  testNode = (Element) elementList.item(0);
  assertNotNull(testNode, "empAddrNotNull");
  state = testNode.hasAttributeNS(namespaceURI, localName);
  assertFalse(state, "throw_False");
 }
}