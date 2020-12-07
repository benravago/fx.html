package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The createTHead() method creates a table header row or returns
* an existing one.
* Create a new THEAD element on the first TABLE element.  The first
* TABLE element should return null to make sure one doesn't exist.
* After creation of the THEAD element the value is once again
* checked and should not be null.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-70313345">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-70313345</a>
*/
class HTML_Table_Element_19_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement19")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLTableSectionElement vsection1;
  HTMLTableSectionElement vsection2;
  HTMLElement newHead;
  Document doc;
  doc = (Document) load("table", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  vsection1 = ((HTMLTableElement) /*Node */testNode).getTHead();
  assertNull(vsection1, "vsection1Id");
  newHead = ((HTMLTableElement) /*Node */testNode).createTHead();
  vsection2 = ((HTMLTableElement) /*Node */testNode).getTHead();
  assertNotNull(vsection2, "vsection2Id");
 }
}