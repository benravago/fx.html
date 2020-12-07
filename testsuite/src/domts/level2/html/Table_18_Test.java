package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The index of this cell in the row. 
* The value of attribute cellIndex of the tablecell element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-80748363">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-80748363</a>
*/
class Table_18_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecell", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table18")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vcindex;
  Node doc;
  doc = (Node) load("tablecell", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("td");
  assertTrue(equalsSize(4, nodeList), "Asize");
  testNode = nodeList.item(1);
  vcindex = (int) ((HTMLTableCellElement) /*Node */testNode).getCellIndex();
  assertEquals(1, vcindex, "cellIndexLink");
 }
}