package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The hspace attribute specifies the horizontal space to the left
* and right of this image, applet, or object. 
* Retrieve the hspace attribute and examine it's value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-1567197">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-1567197</a>
*/
class HTML_Applet_Element_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "applet", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAppletElement07")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vhspace;
  Node doc;
  doc = (Node) load("applet", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("applet");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vhspace = Integer.parseInt(((HTMLAppletElement) /*Node */testNode).getHspace());
  assertEquals(0, vhspace, "hspaceLink");
 }
}