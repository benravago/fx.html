package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The id specifies the elements identifier. 
* Retrieve the id attribute of the ABBR element and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-63534901">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-63534901</a>
*/
class HTML_Element_23_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "element", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLElement23")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vid;
  Document doc;
  doc = (Document) load("element", false);
  nodeList = doc.getElementsByTagName("abbr");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vid = ((HTMLElement) /*Node */testNode).getId();
  assertEquals("Test-ABBR", vid, "idLink");
 }
}