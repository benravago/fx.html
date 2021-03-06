package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The width attribute overrides the original width value.                
* Retrieve the width attribute of the first OBJECT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-38538620">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-38538620</a>
*/
class HTML_Object_Element_17_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLObjectElement17")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vwidth;
  Document doc;
  doc = (Document) load("object", false);
  nodeList = doc.getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vwidth = ((HTMLObjectElement) /*Node */testNode).getWidth();
  assertEquals("550", vwidth, "widthLink");
 }
}