package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The insertRow() method inserts a new empty table row.  
* 
* Retrieve the second TABLE element and invoke the insertRow() method
* with an index of four. After the new row is inserted the number of rows
* in the table should be five.
* Also the number of rows in the TFOOT section before
* insertion of the new row is one.  After the new row is inserted the number 
* of rows in the TFOOT section is two.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39872903">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39872903</a>
*/
class HTML_Table_Element_30_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement30")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection tbodiesnodeList;
  Node testNode;
  HTMLElement newRow;
  HTMLCollection rowsnodeList;
  HTMLTableSectionElement vsection1;
  int vrows;
  Document doc;
  doc = (Document) load("table", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(4, vrows, "rowsLink1");
  vsection1 = ((HTMLTableElement) /*Node */testNode).getTFoot();
  rowsnodeList = vsection1.getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(1, vrows, "rowsLink");
  newRow = ((HTMLTableElement) /*Node */testNode).insertRow(4);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(5, vrows, "rowsLink2");
  vsection1 = ((HTMLTableElement) /*Node */testNode).getTFoot();
  rowsnodeList = vsection1.getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(2, vrows, "rowsLink3");
 }
}