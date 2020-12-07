package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-21738539">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-21738539</a>
*/
class DList_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "dl", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/dlist01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vcompact;
  Node doc;
  doc = (Node) load("dl", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("dl");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcompact = ((HTMLDListElement) /*Node */testNode).getCompact();
  assertTrue(vcompact, "compactLink");
 }
}