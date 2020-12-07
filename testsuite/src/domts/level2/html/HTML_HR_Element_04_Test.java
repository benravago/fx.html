package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The width attribute specifies the width of the rule. 
* Retrieve the width attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-87744198">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-87744198</a>
*/
class HTML_HR_Element_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hr", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLHRElement04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vwidth;
  Document doc;
  doc = (Document) load("hr", false);
  nodeList = doc.getElementsByTagName("hr");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vwidth = ((HTMLHRElement) /*Node */testNode).getWidth();
  assertEquals("400", vwidth, "widthLink");
 }
}