package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The vspace attribute specifies the vertical space above and below this  
* image.
* Retrieve the vspace attribute and examine it's value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-85374897">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-85374897</a>
*/
class HTML_Image_Element_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "img", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLImageElement11")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vvspace;
  Node doc;
  doc = (Node) load("img", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("img");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvspace = Integer.parseInt(((HTMLImageElement) /*Node */testNode).getVspace());
  assertEquals(10, vvspace, "vspaceLink");
 }
}