package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* List of id attribute values for header cells.
* The value of attribute headers of the tablecell element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-89104817">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-89104817</a>
*/
class Table_30_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecell", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table30")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vheaders;
  Node doc;
  doc = (Node) load("tablecell", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("td");
  assertTrue(equalsSize(4, nodeList), "Asize");
  testNode = nodeList.item(1);
  vheaders = ((HTMLTableCellElement) /*Node */testNode).getHeaders();
  assertEquals("header-3", vheaders, "headersLink");
 }
}