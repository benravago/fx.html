package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The className attribute specifies the class attribute of the element. 
* Retrieve the class attribute of the S element and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-95362176">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-95362176</a>
*/
class HTML_Element_126_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "element", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLElement126")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vclassname;
  Document doc;
  doc = (Document) load("element", false);
  nodeList = doc.getElementsByTagName("s");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vclassname = ((HTMLElement) /*Node */testNode).getClassName();
  assertEquals("S-class", vclassname, "classNameLink");
 }
}