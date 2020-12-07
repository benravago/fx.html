package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The target attribute specifies the default target frame.
* Retrieve the target attribute and examine its value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-73844298">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-73844298</a>
*/
class HTML_Base_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "base2", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLBaseElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vtarget;
  Document doc;
  doc = (Document) load("base2", false);
  nodeList = doc.getElementsByTagName("base");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtarget = ((HTMLBaseElement) /*Node */testNode).getTarget();
  assertEquals("Frame1", vtarget, "targetLink");
 }
}