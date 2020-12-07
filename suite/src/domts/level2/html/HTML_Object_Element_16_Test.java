package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The vspace attribute specifies the vertical space above or below this    
* image, applet or object.
* Retrieve the vspace attribute of the first OBJECT element and examine
* it's value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-8682483">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-8682483</a>
*/
class HTML_Object_Element_16_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLObjectElement16")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vvspace;
  Node doc;
  doc = (Node) load("object", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvspace = Integer.parseInt(((HTMLObjectElement) /*Node */testNode).getVspace());
  assertEquals(0, vvspace, "vspaceLink");
 }
}