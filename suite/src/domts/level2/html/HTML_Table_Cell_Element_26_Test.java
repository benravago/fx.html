package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The scope attribute specifies the scope covered by data cells.  
* Retrieve the scope attribute from the second TD element and examine
* its value. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-36139952">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-36139952</a>
*/
class HTML_Table_Cell_Element_26_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecell", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableCellElement26")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vscope;
  Document doc;
  doc = (Document) load("tablecell", false);
  nodeList = doc.getElementsByTagName("td");
  assertTrue(equalsSize(4, nodeList), "Asize");
  testNode = nodeList.item(1);
  vscope = ((HTMLTableCellElement) /*Node */testNode).getScope();
  assertEquals("col", vscope, "scopeLink");
 }
}