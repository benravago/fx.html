package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The cellpadding attribute specifies the horizontal and vertical space
* between cell content and cell borders.
* Retrieve the cellpadding attribute of the first TABLE element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-59162158">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-59162158</a>
*/
class HTML_Table_Element_13_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement13")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcellpadding;
  Document doc;
  doc = (Document) load("table", false);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  vcellpadding = ((HTMLTableElement) /*Node */testNode).getCellPadding();
  assertEquals("2", vcellpadding, "cellPaddingLink");
 }
}