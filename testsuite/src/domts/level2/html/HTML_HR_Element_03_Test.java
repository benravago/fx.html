package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The size attribute specifies the height of the rule. 
* Retrieve the size attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-77612587">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-77612587</a>
*/
class HTML_HR_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hr", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLHRElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vsize;
  Document doc;
  doc = (Document) load("hr", false);
  nodeList = doc.getElementsByTagName("hr");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vsize = ((HTMLHRElement) /*Node */testNode).getSize();
  assertEquals("5", vsize, "sizeLink");
 }
}