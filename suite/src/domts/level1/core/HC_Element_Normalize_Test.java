package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Append a couple of text nodes to the first sup element, normalize the
* document element and check that the element has been normalized.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-162CF083">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-162CF083</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=546">http://www.w3.org/Bugs/Public/show_bug.cgi?id=546</a>
*/
class HC_Element_Normalize_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementnormalize")
 void run() throws Throwable {
  Document doc;
  Element root;
  NodeList elementList;
  Element testName;
  Node firstChild;
  String childValue;
  Text textNode;
  Node retNode;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("sup");
  testName = (Element) elementList.item(0);
  textNode = doc.createTextNode("");
  retNode = testName.appendChild(textNode);
  textNode = doc.createTextNode(",000");
  retNode = testName.appendChild(textNode);
  root = doc.getDocumentElement();
  root.normalize();
  elementList = doc.getElementsByTagName("sup");
  testName = (Element) elementList.item(0);
  firstChild = testName.getFirstChild();
  childValue = firstChild.getNodeValue();
  assertEquals("56,000,000", childValue, "elementNormalizeAssert");
 }
}