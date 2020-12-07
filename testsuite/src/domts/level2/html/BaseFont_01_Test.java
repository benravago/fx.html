package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The value of attribute color of the basefont element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-87502302">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-87502302</a>
*/
class BaseFont_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "basefont", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/basefont01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcolor;
  Node doc;
  doc = (Node) load("basefont", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("basefont");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcolor = ((HTMLBaseFontElement) /*Node */testNode).getColor();
  assertEquals("#000000", vcolor, "colorLink");
 }
}