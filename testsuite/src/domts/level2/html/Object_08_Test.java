package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Horizontal space to the left and right of this image, applet, or object.
* The value of attribute hspace of the object element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-17085376">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-17085376</a>
*/
class Object_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/object08")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vhspace;
  Node doc;
  doc = (Node) load("object", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vhspace = Integer.parseInt(((HTMLObjectElement) /*Node */testNode).getHspace());
  assertEquals(0, vhspace, "hspaceLink");
 }
}