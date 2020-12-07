package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The marginHeight attribute specifies the frame margin height, in pixels.
* Retrieve the marginHeight attribute of the first IFRAME element and examine
* it's value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-91371294">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-91371294</a>
*/
class HTML_IFrame_Element_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "iframe", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLIFrameElement06")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vmarginheight;
  Document doc;
  doc = (Document) load("iframe", false);
  nodeList = doc.getElementsByTagName("iframe");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vmarginheight = ((HTMLIFrameElement) /*Node */testNode).getMarginHeight();
  assertEquals("10", vmarginheight, "marginheightLink");
 }
}