package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Vertical alignment of data in cells.
* The value of attribute valign of the tablesection element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-64197097">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-64197097</a>
*/
class Table_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablesection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table06")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLTableSectionElement vsection;
  String vvAlign;
  Node doc;
  doc = (Node) load("tablesection", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("table");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(1);
  vsection = ((HTMLTableElement) /*Node */testNode).getTFoot();
  vvAlign = vsection.getVAlign();
  assertEquals("middle", vvAlign, "vAlignLink");
 }
}