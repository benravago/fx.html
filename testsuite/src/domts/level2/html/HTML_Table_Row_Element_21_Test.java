package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The deleteCell() method deletes a cell from the currtent row.  If
* the index is -1 the last cell in the row is deleted.
* 
* Retrieve the fourth TR element and examine the value of
* the cells length attribute which should be set to six.  
* Check the value of the last TD element.  Invoke the
* deleteCell() with an index of negative one
* which will delete the last cell in the row. 
* Check the value of the of the last cell 
* and also the numbers of cells should now be five.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-11738598">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-11738598</a>
*/
class HTML_Table_Row_Element_21_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablerow", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableRowElement21")
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
  trNode = cellsnodeList.item(5);
  cellNode = trNode.getFirstChild();
  value = cellNode.getNodeValue();
  assertEquals("1230 North Ave. Dallas, Texas 98551", value, "value1Link");
  ((HTMLTableRowElement) /*Node */testNode).deleteCell(-1);
  testNode = nodeList.item(3);
  cellsnodeList = ((HTMLTableRowElement) /*Node */testNode).getCells();
  vcells = (int) cellsnodeList.getLength();
  assertEquals(5, vcells, "cellsLink2");
  trNode = cellsnodeList.item(4);
  cellNode = trNode.getFirstChild();
  value = cellNode.getNodeValue();
  assertEquals("Female", value, "value2Link");
 }
}