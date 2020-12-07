package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Specifies which internal table borders to render.
* The value of attribute rules of the table element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-26347553">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-26347553</a>
*/
class Table_40_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table40")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vrules;
  Node doc;
  doc = (Node) load("table", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  vrules = ((HTMLTableElement) /*Node */testNode).getRules();
  assertEquals("all", vrules, "rulesLink");
 }
}