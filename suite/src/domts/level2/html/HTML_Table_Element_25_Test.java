package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The createCaption() method creates a new table caption object or returns
* an existing one.
* Create a new CAPTION element on the first TABLE element.  Since
* one does not currently exist the CAPTION element is created.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96920263">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96920263</a>
*/
class HTML_Table_Element_25_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement25")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLTableCaptionElement vsection1;
  HTMLTableCaptionElement vsection2;
  HTMLElement newCaption;
  Document doc;
  doc = (Document) load("table", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  vsection1 = ((HTMLTableElement) /*Node */testNode).getCaption();
  assertNull(vsection1, "vsection1Id");
  newCaption = ((HTMLTableElement) /*Node */testNode).createCaption();
  vsection2 = ((HTMLTableElement) /*Node */testNode).getCaption();
  assertNotNull(vsection2, "vsection2Id");
 }
}