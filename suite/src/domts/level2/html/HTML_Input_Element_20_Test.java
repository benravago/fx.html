package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* HTMLInputElement.focus should capture input focus.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-65996295">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-65996295</a>
*/
class HTML_Input_Element_20_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement20")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Document doc;
  doc = (Document) load("input", true);
  nodeList = doc.getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(1);
  ((HTMLInputElement) /*Node */testNode).focus();
 }
}