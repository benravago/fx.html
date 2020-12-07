package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The target attribute specifies the frame to render the resource in.
* Retrieve the target attribute and examine it's value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-84183095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-84183095</a>
*/
class HTML_Link_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "link2", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLLinkElement09")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vtarget;
  Document doc;
  doc = (Document) load("link2", false);
  nodeList = doc.getElementsByTagName("link");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtarget = ((HTMLLinkElement) /*Node */testNode).getTarget();
  assertEquals("dynamic", vtarget, "targetLink");
 }
}