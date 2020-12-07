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
* with an index of 0. Currently the zero indexed row is in the THEAD
* section of the TABLE.  The number of rows in the THEAD section before
* insertion of the new row is one.  After the new row is inserted the number 
* of rows in the THEAD section is two.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39872903">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39872903</a>
*/
class HTML_Table_Element_28_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement28")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLElement newRow;
  HTMLCollection rowsnodeList;
  HTMLTableSectionElement vsection1;
  HTMLTableSectionElement vsection2;
  int vrows;
  Document doc;
  doc = (Document) load("table", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  vsection1 = ((HTMLTableElement) /*Node */testNode).getTHead();
  rowsnodeList = vsection1.getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(1, vrows, "rowsLink1");
  newRow = ((HTMLTableElement) /*Node */testNode).insertRow(0);
  vsection2 = ((HTMLTableElement) /*Node */testNode).getTHead();
  rowsnodeList = vsection2.getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(2, vrows, "rowsLink2");
 }
}