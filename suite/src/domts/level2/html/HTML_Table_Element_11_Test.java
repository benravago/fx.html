package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The bgColor attribute specifies cell background color.
* Retrieve the bgColor attribute of the first TABLE element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-83532985">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-83532985</a>
*/
class HTML_Table_Element_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement11")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vbgcolor;
  Document doc;
  doc = (Document) load("table", false);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  vbgcolor = ((HTMLTableElement) /*Node */testNode).getBgColor();
  assertEquals("#ff0000", vbgcolor, "bgColorLink");
 }
}