package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The target attribute specifies the frame to render the source in.
* Retrieve the target attribute and examine it's value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-6414197">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-6414197</a>
*/
class HTML_Anchor_Element_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "anchor2", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAnchorElement11")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vtarget;
  Document doc;
  doc = (Document) load("anchor2", false);
  nodeList = doc.getElementsByTagName("a");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtarget = ((HTMLAnchorElement) /*Node */testNode).getTarget();
  assertEquals("dynamic", vtarget, "targetLink");
 }
}