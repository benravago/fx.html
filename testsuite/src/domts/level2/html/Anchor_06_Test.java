package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The shape of the active area. The coordinates are given by coords
* The value of attribute shape of the anchor element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-49899808">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-49899808</a>
*/
class Anchor_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "anchor", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/anchor06")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vshape;
  Node doc;
  doc = (Node) load("anchor", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("a");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vshape = ((HTMLAnchorElement) /*Node */testNode).getShape();
  assertEquals("rect", vshape, "shapeLink");
 }
}