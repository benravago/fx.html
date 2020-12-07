package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Alignment character for cells in a column.
* The value of attribute ch of the tablerow element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-16230502">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-16230502</a>
*/
class Table_45_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablerow", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table45")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vch;
  Node doc;
  doc = (Node) load("tablerow", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("tr");
  assertTrue(equalsSize(5, nodeList), "Asize");
  testNode = nodeList.item(1);
  vch = ((HTMLTableRowElement) /*Node */testNode).getCh();
  assertEquals("*", vch, "vchLink");
 }
}