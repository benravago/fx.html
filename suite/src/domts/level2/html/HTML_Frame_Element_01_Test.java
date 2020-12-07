package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The frameBorder attribute specifies the request for frame borders.    
* (frameBorder=1 A border is drawn)
* (FrameBorder=0 A border is not drawn)
* Retrieve the frameBorder attribute of the first FRAME element and examine
* it's value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-11858633">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-11858633</a>
*/
class HTML_Frame_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "frame", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFrameElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vframeborder;
  Document doc;
  doc = (Document) load("frame", false);
  nodeList = doc.getElementsByTagName("frame");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vframeborder = ((HTMLFrameElement) /*Node */testNode).getFrameBorder();
  assertEquals("1", vframeborder, "frameborderLink");
 }
}