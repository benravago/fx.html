package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The insertRow() method inserts a new empty table row. 
* If index is -1 or equal to the number of rows, the new row
* is appended.
* 
* Retrieve the second TABLE element and invoke the insertRow() method
* with an index of negative one.   
* The number of rows in the TBODY section before insertion with an index
* of negative one is two.  After the new row is inserted the number 
* of rows in the TBODY section is three.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-39872903">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-39872903</a>
*/
class HTML_Table_Element_39_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement39")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection tbodiesnodeList;
  Node testNode;
  Node bodyNode;
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
  tbodiesnodeList = ((HTMLTableElement) /*Node */testNode).getTBodies();
  bodyNode = tbodiesnodeList.item(0);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */bodyNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(2, vrows, "rowsLink1");
  newRow = ((HTMLTableElement) /*Node */testNode).insertRow(-1);
  tbodiesnodeList = ((HTMLTableElement) /*Node */testNode).getTBodies();
  bodyNode = tbodiesnodeList.item(0);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */bodyNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(3, vrows, "rowsLink2");
 }
}