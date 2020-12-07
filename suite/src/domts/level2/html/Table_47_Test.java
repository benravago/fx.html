package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The index of this row, relative to the entire table. 
* The value of attribute rowIndex of the table element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-67347567">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-67347567</a>
*/
class Table_47_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablerow", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table47")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vrindex;
  Node doc;
  doc = (Node) load("tablerow", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("tr");
  assertTrue(equalsSize(5, nodeList), "Asize");
  testNode = nodeList.item(4);
  vrindex = (int) ((HTMLTableRowElement) /*Node */testNode).getRowIndex();
  assertEquals(2, vrindex, "rowIndexLink");
 }
}