package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The ch attribute specifies the alignment character for cells in a
* column.
* Retrieve the char attribute of the first TFOOT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-83470012">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-83470012</a>
*/
class HTML_Table_Section_Element_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablesection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableSectionElement05")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vch;
  Document doc;
  doc = (Document) load("tablesection", false);
  nodeList = doc.getElementsByTagName("tfoot");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vch = ((HTMLTableSectionElement) /*Node */testNode).getCh();
  assertEquals("+", vch, "chLink");
 }
}