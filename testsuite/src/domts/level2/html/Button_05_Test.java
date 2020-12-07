package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* A single character access key to give access to the form control.
* The value of attribute accessKey of the button element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-73169431">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-73169431</a>
*/
class Button_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "button", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/button05")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vakey;
  Node doc;
  doc = (Node) load("button", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("button");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vakey = ((HTMLButtonElement) /*Node */testNode).getAccessKey();
  assertTrue(equalsIgnoreCase("f", vakey), "accessKeyLink");
 }
}