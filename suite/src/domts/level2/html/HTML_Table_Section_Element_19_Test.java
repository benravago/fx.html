package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The insertRow() method inserts a new empty table row.  
* 
* Retrieve the first THEAD element and invoke the insertRow() method
* with an index of 1.  The nuber of rows in the THEAD section before 
* insertion of the new row is one therefore the new row is appended.
* After the new row is inserted the number of rows in the THEAD 
* section is two.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-93995626">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-93995626</a>
*/
class HTML_Table_Section_Element_19_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablesection", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableSectionElement19")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLElement newRow;
  HTMLCollection rowsnodeList;
  int vrows;
  Document doc;
  doc = (Document) load("tablesection", true);
  nodeList = doc.getElementsByTagName("thead");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(1, vrows, "rowsLink1");
  newRow = ((HTMLTableSectionElement) /*Node */testNode).insertRow(1);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(2, vrows, "rowsLink2");
 }
}