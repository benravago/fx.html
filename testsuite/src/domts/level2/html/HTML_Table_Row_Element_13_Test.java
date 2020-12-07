package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The deleteCell() method deletes a cell from the current row.   
* 
* Retrieve the fourth TR element and examine the value of
* the cells length attribute which should be set to six.  
* Check the value of the first TD element.  Invoke the
* deleteCell() method which will delete a cell from the current row.
* Check the value of the cell at the zero index and also check
* the number of cells which should now be five. 
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-11738598">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-11738598</a>
*/
class HTML_Table_Row_Element_13_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablerow", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableRowElement13")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection cellsnodeList;
  Node testNode;
  Node trNode;
  Node cellNode;
  String value;
  int vcells;
  Document doc;
  doc = (Document) load("tablerow", true);
  nodeList = doc.getElementsByTagName("tr");
  assertTrue(equalsSize(5, nodeList), "Asize");
  testNode = nodeList.item(3);
  cellsnodeList = ((HTMLTableRowElement) /*Node */testNode).getCells();
  vcells = (int) cellsnodeList.getLength();
  assertEquals(6, vcells, "cellsLink1");
  trNode = cellsnodeList.item(0);
  cellNode = trNode.getFirstChild();
  value = cellNode.getNodeValue();
  assertEquals("EMP0001", value, "value1Link");
  ((HTMLTableRowElement) /*Node */testNode).deleteCell(0);
  testNode = nodeList.item(3);
  cellsnodeList = ((HTMLTableRowElement) /*Node */testNode).getCells();
  vcells = (int) cellsnodeList.getLength();
  assertEquals(5, vcells, "cellsLink2");
  trNode = cellsnodeList.item(0);
  cellNode = trNode.getFirstChild();
  value = cellNode.getNodeValue();
  assertEquals("Margaret Martin", value, "value2Link");
 }
}