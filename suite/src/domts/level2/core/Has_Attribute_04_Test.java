package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "hasAttribute()" method for an Element should 
* return true if the element has an attribute with the given name.
* Retrieve the first "address" element and the "hasAttribute()" method
* should return true since the element has "domestic" as an attribute.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttr">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttr</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=238">http://www.w3.org/Bugs/Public/show_bug.cgi?id=238</a>
*/
class Has_Attribute_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/hasAttribute04")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testNode;
  boolean state;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("address");
  testNode = (Element) elementList.item(0);
  state = testNode.hasAttribute("dmstc:domestic");
  assertTrue(state, "hasDomesticAttr");
 }
}