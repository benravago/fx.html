package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Vertical alignment of cell data in column.
* The value of attribute valign of the tablecol element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-83291710">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-83291710</a>
*/
class Table_52_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecol", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table52")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vvalign;
  Node doc;
  doc = (Node) load("tablecol", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("col");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvalign = ((HTMLTableColElement) /*Node */testNode).getVAlign();
  assertEquals("middle", vvalign, "vAlignLink");
 }
}