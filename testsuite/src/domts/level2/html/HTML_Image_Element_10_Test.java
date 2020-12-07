package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The useMap attribute specifies to use the client-side image map.
* Retrieve the useMap attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-35981181">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-35981181</a>
*/
class HTML_Image_Element_10_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "img", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLImageElement10")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vusemap;
  Document doc;
  doc = (Document) load("img", false);
  nodeList = doc.getElementsByTagName("img");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vusemap = ((HTMLImageElement) /*Node */testNode).getUseMap();
  assertEquals("#DTS-MAP", vusemap, "useMapLink");
 }
}