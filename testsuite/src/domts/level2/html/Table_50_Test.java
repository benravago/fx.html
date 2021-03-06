package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Offset of alignment character.
* The value of attribute choff of the tablecol element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-68207461">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-68207461</a>
*/
class Table_50_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecol", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/table50")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vchoff;
  Node doc;
  doc = (Node) load("tablecol", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("col");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vchoff = ((HTMLTableColElement) /*Node */testNode).getChOff();
  assertEquals("20", vchoff, "chOffLink");
 }
}