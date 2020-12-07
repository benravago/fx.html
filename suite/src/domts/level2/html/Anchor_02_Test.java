package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The character encoding of the linked resource.
* The value of attribute charset of the anchor element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-67619266">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-67619266</a>
*/
class Anchor_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "anchor", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/anchor02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcharset;
  Node doc;
  doc = (Node) load("anchor", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("a");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcharset = ((HTMLAnchorElement) /*Node */testNode).getCharset();
  assertEquals("US-ASCII", vcharset, "charsetLink");
 }
}