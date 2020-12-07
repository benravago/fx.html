package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The target specifies the frame to render the resource in.   
* Retrieve the target attribute and examine it's value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-46054682">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-46054682</a>
*/
class HTML_Area_Element_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "area2", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAreaElement08")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vtarget;
  Document doc;
  doc = (Document) load("area2", false);
  nodeList = doc.getElementsByTagName("area");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtarget = ((HTMLAreaElement) /*Node */testNode).getTarget();
  assertEquals("dynamic", vtarget, "targetLink");
 }
}