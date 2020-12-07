package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Color of active links (after mouse-button down, but before mouse-button up).
* The value of attribute alink of the body element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-59424581">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-59424581</a>
*/
class Body_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "body", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/body01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String valink;
  Node doc;
  doc = (Node) load("body", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("body");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  valink = ((HTMLBodyElement) /*Node */testNode).getALink();
  assertEquals("#0000ff", valink, "aLinkLink");
 }
}