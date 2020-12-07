package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The isMap attribute indicates the use of server-side image map.
* Retrieve the isMap attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-58983880">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-58983880</a>
*/
class HTML_Image_Element_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "img", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLImageElement07")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vismap;
  Document doc;
  doc = (Document) load("img", false);
  nodeList = doc.getElementsByTagName("img");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vismap = ((HTMLImageElement) /*Node */testNode).getIsMap();
  assertFalse(vismap, "isMapLink");
 }
}