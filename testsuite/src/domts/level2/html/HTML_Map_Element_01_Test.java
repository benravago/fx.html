package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The  areas attribute is a list of areas defined for the image map.
* Retrieve the areas attribute and find the number of areas defined.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-71838730">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-71838730</a>
*/
class HTML_Map_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "map", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLMapElement01")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection areasnodeList;
  Node testNode;
  int vareas;
  Document doc;
  doc = (Document) load("map", false);
  nodeList = doc.getElementsByTagName("map");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  areasnodeList = ((HTMLMapElement) /*Node */testNode).getAreas();
  vareas = (int) areasnodeList.getLength();
  assertEquals(3, vareas, "areasLink");
 }
}