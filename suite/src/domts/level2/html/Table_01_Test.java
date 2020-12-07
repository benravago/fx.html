package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Returns the table's CAPTION, or void if none exists. 
* The value of attribute caption of the table element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-14594520">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-14594520</a>
*/
class Table_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table1", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Node vcaption;
  Node doc;
  doc = (Node) load("table1", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("table");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcaption = ((HTMLTableElement) /*Node */testNode).getCaption();
  assertNull(vcaption, "captionLink");
 }
}