package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Calling HTMLTextAreaElement.select should select the text area.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-48880622">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-48880622</a>
*/
class HTML_TextArea_Element_15_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "textarea", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTextAreaElement15")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Document doc;
  doc = (Document) load("textarea", true);
  nodeList = doc.getElementsByTagName("textarea");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  ((HTMLTextAreaElement) /*Node */testNode).select();
 }
}