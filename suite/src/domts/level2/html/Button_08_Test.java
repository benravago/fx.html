package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The control is unavailable in this context. 
* The boolean value of attribute disabled of the button element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-92757155">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-92757155</a>
*/
class Button_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "button", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/button08")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vdisabled;
  Node doc;
  doc = (Node) load("button", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("button");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vdisabled = ((HTMLButtonElement) /*Node */testNode).getDisabled();
  assertTrue(vdisabled, "disabledLink");
 }
}