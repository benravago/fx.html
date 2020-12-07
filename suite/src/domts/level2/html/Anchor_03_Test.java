package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Comma-separated list of lengths, defining an active region geometry.
* The value of attribute coords of the anchor element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-92079539">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-92079539</a>
*/
class Anchor_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "anchor", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/anchor03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcoords;
  Node doc;
  doc = (Node) load("anchor", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("a");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcoords = ((HTMLAnchorElement) /*Node */testNode).getCoords();
  assertEquals("0,0,100,100", vcoords, "coordsLink");
 }
}