package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The deleteRow() method deletes a row from this section.  The index
* starts from 0 and is relative only to the rows contained inside
* this section, not all the rows in the table.  If the index is -1
* the last row will be deleted.
* 
* Retrieve the second TBODY element and invoke the deleteRow() method
* with an index of -1.  The nuber of rows in the THEAD section before 
* the deletion of the row is two.  After the row is deleted the number 
* of rows in the TBODY section is one.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-5625626">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-5625626</a>
*/
class HTML_Table_Section_Element_31_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablesection", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableSectionElement31")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLCollection rowsnodeList;
  int vrows;
  Document doc;
  doc = (Document) load("tablesection", true);
  nodeList = doc.getElementsByTagName("tbody");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(1);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(2, vrows, "rowsLink1");
  ((HTMLTableSectionElement) /*Node */testNode).deleteRow(-1);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(1, vrows, "rowsLink2");
 }
}