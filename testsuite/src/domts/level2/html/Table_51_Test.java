package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Indicates the number of columns in a group or affected by a grouping.
* The value of attribute span of the tablecol element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96511335">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96511335</a>
*/
class Table_51_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecol", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table51")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vspan;
  Node doc;
  doc = (Node) load("tablecol", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("col");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vspan = (int) ((HTMLTableColElement) /*Node */testNode).getSpan();
  assertEquals(1, vspan, "spanLink");
 }
}