package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The value attribute is a reset sequence number when used in OL. 
* Retrieve the value attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-45496263">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-45496263</a>
*/
class HTML_LI_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "li", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLLIElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vvalue;
  Document doc;
  doc = (Document) load("li", false);
  nodeList = doc.getElementsByTagName("li");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvalue = (int) ((HTMLLIElement) /*Node */testNode).getValue();
  assertEquals(2, vvalue, "valueLink");
 }
}