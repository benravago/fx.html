package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Content type for data downloaded via classid attribute.
* The value of attribute codetype of the object element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-19945008">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-19945008</a>
*/
class Object_15_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/object15")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcodetype;
  Node doc;
  doc = (Node) load("object", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(1);
  vcodetype = ((HTMLObjectElement) /*Node */testNode).getCodeType();
  assertEquals("image/gif", vcodetype, "codeTypeLink");
 }
}