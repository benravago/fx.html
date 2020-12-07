package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The border attribute specifies the width of the border around the table.
* Retrieve the border attribute of the first TABLE element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-50969400">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-50969400</a>
*/
class HTML_Table_Element_12_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement12")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vborder;
  Document doc;
  doc = (Document) load("table", false);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  vborder = ((HTMLTableElement) /*Node */testNode).getBorder();
  assertEquals("4", vborder, "borderLink");
 }
}