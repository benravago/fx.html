package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Horizontal alignment of data within cells of this row.
* The value of attribute align of the tablerow element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-74098257">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-74098257</a>
*/
class Table_42_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table42")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String valign;
  Node doc;
  doc = (Node) load("table", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("tr");
  assertTrue(equalsSize(8, nodeList), "Asize");
  testNode = nodeList.item(1);
  valign = ((HTMLTableRowElement) /*Node */testNode).getAlign();
  assertEquals("center", valign, "alignLink");
 }
}