package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Index that represents the element's position in the tabbing order.
* The value of attribute tabIndex of the object element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-27083787">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-27083787</a>
*/
class Object_10_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/object10")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vtabindex;
  Node doc;
  doc = (Node) load("object", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtabindex = (int) ((HTMLObjectElement) /*Node */testNode).getTabIndex();
  assertEquals(0, vtabindex, "tabIndexLink");
 }
}