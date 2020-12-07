package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The insertCell() method inserts an empty TD cell into this row. 
* If index is -1 or equal to the number of cells, the new cell is
* appended.
* 
* Retrieve the fourth TR element and examine the value of
* the cells length attribute which should be set to six.  
* Check the value of the last TD element.  Invoke the
* insertCell() with an index of negative one
* which will append the empty cell to the end of the list.
* Check the value of the newly created cell and make sure it is null
* and also the numbers of cells should now be seven.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-68927016">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-68927016</a>
*/
class HTML_Table_Row_Element_20_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablerow", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableRowElement20")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection cellsnodeList;
  Node testNode;
  Node trNode;
  Node cellNode;
  String value;
  HTMLElement newCell;
  int vcells;
  Document doc;
  doc = (Document) load("tablerow", true);
  nodeList = doc.getElementsByTagName("tr");
  assertTrue(equalsSize(5, nodeList), "Asize");
  testNode = nodeList.item(3);
  cellsnodeList = ((HTMLTableRowElement) /*Node */testNode).getCells();
  vcells = (int) cellsnodeList.getLength();
  assertEquals(6, vcells, "cellsLink1");
  trNode = cellsnodeList.item(5);
  cellNode = trNode.getFirstChild();
  value = cellNode.getNodeValue();
  assertEquals("1230 North Ave. Dallas, Texas 98551", value, "value1Link");
  newCell = ((HTMLTableRowElement) /*Node */testNode).insertCell(-1);
  testNode = nodeList.item(3);
  cellsnodeList = ((HTMLTableRowElement) /*Node */testNode).getCells();
  vcells = (int) cellsnodeList.getLength();
  assertEquals(7, vcells, "cellsLink2");
  trNode = cellsnodeList.item(6);
  cellNode = trNode.getFirstChild();
  assertNull(cellNode, "value2Link");
 }
}