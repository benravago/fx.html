package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The clear attribute specifies control flow of text around floats. 
* Retrieve the clear attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-82703081">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-82703081</a>
*/
class HTML_BR_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "br", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLBRElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vclear;
  Document doc;
  doc = (Document) load("br", false);
  nodeList = doc.getElementsByTagName("br");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vclear = ((HTMLBRElement) /*Node */testNode).getClear();
  assertEquals("none", vclear, "clearLink");
 }
}