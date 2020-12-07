package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The createTFoot() method creates a table footer row or returns
* an existing one.
* Create a new TFOOT element on the first TABLE element.  The first
* TABLE element should return null to make sure one doesn't exist.
* After creation of the TFOOT element the value is once again
* checked and should not be null.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-8453710">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-8453710</a>
*/
class HTML_Table_Element_22_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement22")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLTableSectionElement vsection1;
  HTMLTableSectionElement vsection2;
  HTMLElement newFoot;
  Document doc;
  doc = (Document) load("table", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  vsection1 = ((HTMLTableElement) /*Node */testNode).getTFoot();
  assertNull(vsection1, "vsection1Id");
  newFoot = ((HTMLTableElement) /*Node */testNode).createTFoot();
  vsection2 = ((HTMLTableElement) /*Node */testNode).getTFoot();
  assertNotNull(vsection2, "vsection2Id");
 }
}