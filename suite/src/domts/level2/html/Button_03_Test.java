package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The value of attribute action of the form element which contains this button is read and checked against the expected value
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-71254493">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-71254493</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-74049184">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-74049184</a>
*/
class Button_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "button", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/button03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Node formNode;
  String vfaction;
  Node doc;
  doc = (Node) load("button", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("button");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  formNode = ((HTMLButtonElement) /*Node */testNode).getForm();
  vfaction = ((HTMLFormElement) /*Node */formNode).getAction();
  assertEquals("...", vfaction, "formLink");
 }
}