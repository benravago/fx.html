package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The alt attribute alternates text for user agents not rendering the
* normal content of this element.
* Retrieve the alt attribute of the 1st INPUT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-92701314">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-92701314</a>
*/
class HTML_Input_Element_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement07")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String valt;
  Document doc;
  doc = (Document) load("input", false);
  nodeList = doc.getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(0);
  valt = ((HTMLInputElement) /*Node */testNode).getAlt();
  assertEquals("Password entry", valt, "altLink");
 }
}