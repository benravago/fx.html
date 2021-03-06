package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The scheme attribute specifies a select form of content. 
* Retrieve the scheme attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-35993789">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-35993789</a>
*/
class HTML_Meta_Element_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "meta", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLMetaElement04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vscheme;
  Document doc;
  doc = (Document) load("meta", false);
  nodeList = doc.getElementsByTagName("meta");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vscheme = ((HTMLMetaElement) /*Node */testNode).getScheme();
  assertEquals("NIST", vscheme, "schemeLink");
 }
}