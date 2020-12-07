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
* Retrieve the frameBorder attribute of the first IFRAME element and examine
* it's value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-22463410">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-22463410</a>
*/
class HTML_IFrame_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "iframe", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLIFrameElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vframeborder;
  Document doc;
  doc = (Document) load("iframe", false);
  nodeList = doc.getElementsByTagName("iframe");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vframeborder = ((HTMLIFrameElement) /*Node */testNode).getFrameBorder();
  assertEquals("1", vframeborder, "frameborderLink");
 }
}