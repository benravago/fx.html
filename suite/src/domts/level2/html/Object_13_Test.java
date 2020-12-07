package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Vertical space above and below this image, applet, or object.
* The value of attribute vspace of the object element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-8682483">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-8682483</a>
*/
class Object_13_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/object13")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vvspace;
  Node doc;
  doc = (Node) load("object", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvspace = Integer.parseInt(((HTMLObjectElement) /*Node */testNode).getVspace());
  assertEquals(0, vvspace, "vspaceLink");
 }
}