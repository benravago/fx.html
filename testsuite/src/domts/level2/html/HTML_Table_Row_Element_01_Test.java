package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The rowIndex attribute specifies the index of the row, relative to the   
* entire table, starting from 0.  This is in document tree order and
* not display order.  The rowIndex does not take into account sections
* (THEAD, TFOOT, or TBODY) within the table.
* Retrieve the third TR element within the document and examine 
* its rowIndex value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-67347567">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-67347567</a>
*/
class HTML_Table_Row_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablerow", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableRowElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vrowindex;
  Document doc;
  doc = (Document) load("tablerow", false);
  nodeList = doc.getElementsByTagName("tr");
  assertTrue(equalsSize(5, nodeList), "Asize");
  testNode = nodeList.item(3);
  vrowindex = (int) ((HTMLTableRowElement) /*Node */testNode).getRowIndex();
  assertEquals(1, vrowindex, "rowIndexLink");
 }
}