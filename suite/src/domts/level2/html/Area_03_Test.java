package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-8722121">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-8722121</a>
*/
class Area_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "area", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/area03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vtabindex;
  Node doc;
  doc = (Node) load("area", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("area");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtabindex = (int) ((HTMLAreaElement) /*Node */testNode).getTabIndex();
  assertEquals(10, vtabindex, "tabIndexLink");
 }
}