package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The height attribute overrides the natural "height" of the image.
* Retrieve the height attribute and examine it's value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-91561496">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-91561496</a>
*/
class HTML_Image_Element_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "img", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLImageElement05")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vheight;
  Node doc;
  doc = (Node) load("img", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("img");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vheight = Integer.parseInt(((HTMLImageElement) /*Node */testNode).getHeight());
  assertEquals(47, vheight, "heightLink");
 }
}