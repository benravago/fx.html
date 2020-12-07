package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "hasAttributeNS()" method for an Element should 
* return true if the element has an attribute with the given local name
* and the namespace URI is specified on this element or has a default value.
* Retrieve the first "address" element and the "hasAttributeNS()" method
* should return true since the element has "domestic" as the local name
* and "http://www.usa.com" as the namespace URI.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttrNS</a>
*/
class Has_Attribute_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/hasAttributeNS05")
 void run() throws Throwable {
  String localName = "domestic";
  String namespaceURI = "http://www.usa.com";
  Document doc;
  NodeList elementList;
  Element testNode;
  boolean state;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("address");
  testNode = (Element) elementList.item(0);
  state = testNode.hasAttributeNS(namespaceURI, localName);
  assertTrue(state, "hasAttribute");
 }
}