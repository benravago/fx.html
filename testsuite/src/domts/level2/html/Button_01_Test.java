package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Returns the FORM element containing this control. Returns null if this control is not within the context of a form. 
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-71254493">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-71254493</a>
*/
class Button_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "button", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/button01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Node vform;
  Node doc;
  doc = (Node) load("button", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("button");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(1);
  vform = ((HTMLButtonElement) /*Node */testNode).getForm();
  assertNull(vform, "formLink");
 }
}