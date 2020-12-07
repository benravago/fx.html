package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The deleteRow() method deletes a table row.  
* 
* Retrieve the second TABLE element and invoke the deleteRow() method
* with an index of 0(first row). Currently there are four rows in the 
* table.  After the deleteRow() method is called there should be
* three rows in the table.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-13114938">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-13114938</a>
*/
class HTML_Table_Element_32_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement32")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLCollection rowsnodeList;
  int vrows;
  Document doc;
  doc = (Document) load("table", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(4, vrows, "rowsLink1");
  ((HTMLTableElement) /*Node */testNode).deleteRow(0);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(3, vrows, "rowsLink2");
 }
}