package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The createTFoot() method creates a table footer row or returns
* an existing one.
* Try to create a new TFOOT element on the second TABLE element.  
* Since a TFOOT element already exists in the TABLE element a new
* TFOOT element is not created and information from the already
* existing TFOOT element is returned.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-8453710">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-8453710</a>
*/
class HTML_Table_Element_23_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement23")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLTableSectionElement vsection;
  HTMLElement newFoot;
  String valign;
  Document doc;
  doc = (Document) load("table", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  newFoot = ((HTMLTableElement) /*Node */testNode).createTFoot();
  vsection = ((HTMLTableElement) /*Node */testNode).getTFoot();
  valign = vsection.getAlign();
  assertEquals("center", valign, "alignLink");
 }
}