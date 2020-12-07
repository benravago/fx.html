package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The noShade attribute specifies that the rule should be drawn as
* a solid color. 
* Retrieve the noShade attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-79813978">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-79813978</a>
*/
class HTML_HR_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hr", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLHRElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vnoshade;
  Document doc;
  doc = (Document) load("hr", false);
  nodeList = doc.getElementsByTagName("hr");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vnoshade = ((HTMLHRElement) /*Node */testNode).getNoShade();
  assertTrue(vnoshade, "noShadeLink");
 }
}