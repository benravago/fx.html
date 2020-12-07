package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Number of columns spanned by cell.
* The value of attribute colspan of the tablecell element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-84645244">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-84645244</a>
*/
class Table_25_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecell", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table25")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vcolspan;
  Node doc;
  doc = (Node) load("tablecell", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("td");
  assertTrue(equalsSize(4, nodeList), "Asize");
  testNode = nodeList.item(1);
  vcolspan = (int) ((HTMLTableCellElement) /*Node */testNode).getColSpan();
  assertEquals(1, vcolspan, "colSpanLink");
 }
}