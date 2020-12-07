package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The alt attribute specifies an alternate text for user agents not
* rendering the normal content of this element.
* Retrieve the alt attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39775416">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39775416</a>
*/
class HTML_Area_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "area", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAreaElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String valt;
  Document doc;
  doc = (Document) load("area", false);
  nodeList = doc.getElementsByTagName("area");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  valt = ((HTMLAreaElement) /*Node */testNode).getAlt();
  assertEquals("Domain", valt, "altLink");
 }
}