package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "hasAttribute()" method for an Element should 
* return false if the element does not have an attribute with the given name.
* Retrieve the first "address" element and the "hasAttribute()" method
* should return false since the element does not have "nomatch" as an attribute.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttr">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttr</a>
*/
class Has_Attribute_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/hasAttribute03")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testNode;
  boolean state;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  testNode = (Element) elementList.item(0);
  state = testNode.hasAttribute("nomatch");
  assertFalse(state, "throw_False");
 }
}