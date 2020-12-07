package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* focus should give the select element input focus.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-32130014">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-32130014</a>
*/
class HTML_Select_Element_14_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "select", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLSelectElement14")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Document doc;
  doc = (Document) load("select", true);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  ((HTMLSelectElement) /*Node */testNode).focus();
 }
}