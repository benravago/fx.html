package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Vertical alignment of data within cells of this row.
* The value of attribute valign of the tablerow element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-90000058">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-90000058</a>
*/
class Table_44_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table44")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vvalign;
  Node doc;
  doc = (Node) load("table", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("tr");
  assertTrue(equalsSize(8, nodeList), "Asize");
  testNode = nodeList.item(1);
  vvalign = ((HTMLTableRowElement) /*Node */testNode).getVAlign();
  assertEquals("middle", vvalign, "valignLink");
 }
}