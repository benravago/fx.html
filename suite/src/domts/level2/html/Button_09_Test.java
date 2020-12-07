package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The current form control value.
* The value of attribute value of the button element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-72856782">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-72856782</a>
*/
class Button_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "button", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/button09")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vvalue;
  Node doc;
  doc = (Node) load("button", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("button");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvalue = ((HTMLButtonElement) /*Node */testNode).getValue();
  assertEquals("Reset Disabled Button", vvalue, "typeLink");
 }
}