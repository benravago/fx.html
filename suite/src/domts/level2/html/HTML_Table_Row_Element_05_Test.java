package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The cells attribute specifies the collection of cells in this row.
* Retrieve the fourth TR element and examine the value of
* the cells length attribute.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-67349879">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-67349879</a>
*/
class HTML_Table_Row_Element_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablerow", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableRowElement05")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection cellsnodeList;
  Node testNode;
  int vcells;
  Document doc;
  doc = (Document) load("tablerow", false);
  nodeList = doc.getElementsByTagName("tr");
  assertTrue(equalsSize(5, nodeList), "Asize");
  testNode = nodeList.item(3);
  cellsnodeList = ((HTMLTableRowElement) /*Node */testNode).getCells();
  vcells = (int) cellsnodeList.getLength();
  assertEquals(6, vcells, "cellsLink");
 }
}