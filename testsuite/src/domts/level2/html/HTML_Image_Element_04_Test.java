package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The border attribute specifies the width of the border around the image.
* Retrieve the border attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-136671">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-136671</a>
*/
class HTML_Image_Element_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "img", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLImageElement04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vborder;
  Document doc;
  doc = (Document) load("img", false);
  nodeList = doc.getElementsByTagName("img");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vborder = ((HTMLImageElement) /*Node */testNode).getBorder();
  assertEquals("0", vborder, "borderLink");
 }
}