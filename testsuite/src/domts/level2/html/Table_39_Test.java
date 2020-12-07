package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Supplementary description about the purpose or structure of a table.
* The value of attribute summary of the table element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-44998528">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-44998528</a>
*/
class Table_39_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table39")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vsummary;
  Node doc;
  doc = (Node) load("table", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  vsummary = ((HTMLTableElement) /*Node */testNode).getSummary();
  assertEquals("HTML Control Table", vsummary, "summaryLink");
 }
}