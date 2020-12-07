package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The hspace attribute specifies the horizontal space to the left and     
* right of this image.
* Retrieve the hspace attribute and examine it's value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-53675471">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-53675471</a>
*/
class HTML_Image_Element_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "img", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLImageElement06")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vhspace;
  Node doc;
  doc = (Node) load("img", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("img");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vhspace = Integer.parseInt(((HTMLImageElement) /*Node */testNode).getHspace());
  assertEquals(4, vhspace, "hspaceLink");
 }
}