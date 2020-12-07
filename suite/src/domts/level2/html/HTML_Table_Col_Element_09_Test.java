package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The vAlign attribute specifies the vertical alignment of cell data
* in column(COL).
* Retrieve the vAlign attribute from the COL element and examine
* its value. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-83291710">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-83291710</a>
*/
class HTML_Table_Col_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecol", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableColElement09")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vvalign;
  Document doc;
  doc = (Document) load("tablecol", false);
  nodeList = doc.getElementsByTagName("col");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvalign = ((HTMLTableColElement) /*Node */testNode).getVAlign();
  assertEquals("middle", vvalign, "vAlignLink");
 }
}