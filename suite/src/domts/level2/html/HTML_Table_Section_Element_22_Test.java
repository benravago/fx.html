package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The deleteRow() method deletes a row from this section.  
* 
* Retrieve the first THEAD element and invoke the deleteRow() method
* with an index of 0.  The nuber of rows in the THEAD section before 
* the deletion of the row is one.  After the row is deleted the number 
* of rows in the THEAD section is zero.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-5625626">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-5625626</a>
*/
class HTML_Table_Section_Element_22_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablesection", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableSectionElement22")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
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
  ((HTMLTableSectionElement) /*Node */testNode).deleteRow(0);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(0, vrows, "rowsLink2");
 }
}