package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The deleteCaption() method deletes the table caption.
* Delete the CAPTION element on the second TABLE element.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-22930071">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-22930071</a>
*/
class HTML_Table_Element_27_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement27")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLTableSectionElement vsection1;
  HTMLTableSectionElement vsection2;
  String valign;
  Document doc;
  doc = (Document) load("table", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  vsection1 = (HTMLTableSectionElement) ((HTMLTableElement) /*Node */testNode).getCaption();
  assertNotNull(vsection1, "vsection1Id");
  ((HTMLTableElement) /*Node */testNode).deleteCaption();
  vsection2 = (HTMLTableSectionElement) ((HTMLTableElement) /*Node */testNode).getCaption();
  assertNull(vsection2, "vsection2Id");
 }
}