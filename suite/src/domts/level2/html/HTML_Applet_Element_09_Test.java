package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The vspace attribute specifies the vertical space above and below
* this image, applet or object.
* Retrieve the vspace attribute and examine it's value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-22637173">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-22637173</a>
*/
class HTML_Applet_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "applet", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAppletElement09")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vvspace;
  Node doc;
  doc = (Node) load("applet", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("applet");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvspace = Integer.parseInt(((HTMLAppletElement) /*Node */testNode).getVspace());
  assertEquals(0, vvspace, "vspaceLink");
 }
}