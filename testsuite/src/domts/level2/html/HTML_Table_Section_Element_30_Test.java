package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The insertRow() method inserts a new empty table row.  The new
* row is inserted immediately before the current indexth row in this
* section.  If index is -1 or equal to the number of rows in this section,
* the new row is appended.
* 
* Retrieve the first THEAD element and invoke the insertRow() method
* with an index of negative one.  Since the index is negative one the 
* new row is appended.
* After the new row is appended the number of rows in the THEAD 
* section is two.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-93995626">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-93995626</a>
*/
class HTML_Table_Section_Element_30_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablesection", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableSectionElement30")
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
  newRow = ((HTMLTableSectionElement) /*Node */testNode).insertRow(-1);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(2, vrows, "rowsLink2");
 }
}