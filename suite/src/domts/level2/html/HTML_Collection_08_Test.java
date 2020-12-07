package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Nodes in a HTMLCollection object are numbered in tree order.         
* (Depth-first traversal order).
* Retrieve the first TABLE element and create a HTMLCollection by invoking
* the "rows" attribute.  Access the item in the third ordinal index.  The
* resulting rowIndex attribute is examined and should be two.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-33262535">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-33262535</a>
*/
class HTML_Collection_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "collection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLCollection08")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Node rowNode;
  HTMLCollection rowsnodeList;
  int vrowindex;
  Document doc;
  doc = (Document) load("collection", false);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  rowsnodeList = ((HTMLTableElement) /*Node */testNode).getRows();
  rowNode = rowsnodeList.item(2);
  vrowindex = (int) ((HTMLTableRowElement) /*Node */rowNode).getRowIndex();
  assertEquals(2, vrowindex, "rowIndexLink");
 }
}