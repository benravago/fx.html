package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The shape attribute contains the shape of the active area.
* Retrieve the shape attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-49899808">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-49899808</a>
*/
class HTML_Anchor_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "anchor", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAnchorElement09")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLAnchorElement testNode;
  String vshape;
  Document doc;
  doc = (Document) load("anchor", false);
  nodeList = doc.getElementsByTagName("a");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = (HTMLAnchorElement) nodeList.item(0);
  vshape = testNode.getShape();
  assertEquals("rect", vshape, "shapeLink");
 }
}