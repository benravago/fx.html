package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The width attribute specifies the default column width(COL).
* Retrieve the width attribute from the COL element and examine
* its value. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-25196799">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-25196799</a>
*/
class HTML_Table_Col_Element_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecol", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableColElement11")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vwidth;
  Document doc;
  doc = (Document) load("tablecol", false);
  nodeList = doc.getElementsByTagName("col");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vwidth = ((HTMLTableColElement) /*Node */testNode).getWidth();
  assertEquals("20", vwidth, "widthLink");
 }
}