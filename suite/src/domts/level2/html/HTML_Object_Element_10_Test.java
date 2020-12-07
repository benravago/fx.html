package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The height attribute overrides the value of the actual height of the    
* object.
* Retrieve the height attribute of the first OBJECT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-88925838">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-88925838</a>
*/
class HTML_Object_Element_10_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLObjectElement10")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vheight;
  Document doc;
  doc = (Document) load("object", false);
  nodeList = doc.getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vheight = ((HTMLObjectElement) /*Node */testNode).getHeight();
  assertEquals("60", vheight, "heightLink");
 }
}