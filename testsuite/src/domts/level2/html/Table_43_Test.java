package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Background color for rows.
* The value of attribute bgcolor of the tablerow element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-18161327">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-18161327</a>
*/
class Table_43_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table43")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vbgcolor;
  Node doc;
  doc = (Node) load("table", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("tr");
  assertTrue(equalsSize(8, nodeList), "Asize");
  testNode = nodeList.item(1);
  vbgcolor = ((HTMLTableRowElement) /*Node */testNode).getBgColor();
  assertTrue(equalsIgnoreCase("#00FFFF", vbgcolor), "bgcolorLink");
 }
}