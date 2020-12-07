package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Specifies the horizontal and vertical separation between cells.
* The value of attribute cellspacing of the table element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-68907883">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-68907883</a>
*/
class Table_38_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table38")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcellspacing;
  Node doc;
  doc = (Node) load("table", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  vcellspacing = ((HTMLTableElement) /*Node */testNode).getCellSpacing();
  assertEquals("2", vcellspacing, "cellspacingLink");
 }
}