package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The vAlign attribute specifies the vertical alignment of cell data in
* column. 
* Retrieve the vAlign attribute of the first THEAD element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-4379116">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-4379116</a>
*/
class HTML_Table_Section_Element_10_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablesection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableSectionElement10")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vvalign;
  Document doc;
  doc = (Document) load("tablesection", false);
  nodeList = doc.getElementsByTagName("thead");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvalign = ((HTMLTableSectionElement) /*Node */testNode).getVAlign();
  assertEquals("middle", vvalign, "vAlignLink");
 }
}