package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Alignment character for cells in a column.
* The value of attribute ch of the tablecol element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-16230502">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-16230502</a>
*/
class Table_49_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecol", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table49")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vch;
  Node doc;
  doc = (Node) load("tablecol", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("col");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vch = ((HTMLTableColElement) /*Node */testNode).getCh();
  assertEquals("*", vch, "chLink");
 }
}