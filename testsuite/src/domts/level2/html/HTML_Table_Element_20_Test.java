package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The createTHead() method creates a table header row or returns
* an existing one.
* Try to create a new THEAD element on the second TABLE element.  
* Since a THEAD element already exists in the TABLE element a new
* THEAD element is not created and information from the already
* existing THEAD element is returned.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-70313345">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-70313345</a>
*/
class HTML_Table_Element_20_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement20")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLTableSectionElement vsection;
  HTMLElement newHead;
  String valign;
  Document doc;
  doc = (Document) load("table", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  newHead = ((HTMLTableElement) /*Node */testNode).createTHead();
  vsection = ((HTMLTableElement) /*Node */testNode).getTHead();
  valign = vsection.getAlign();
  assertEquals("center", valign, "alignLink");
 }
}