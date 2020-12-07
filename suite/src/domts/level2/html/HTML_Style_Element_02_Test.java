package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The media attribute identifies the intended medium of the style info.
* Retrieve the media attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-76412738">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-76412738</a>
*/
class HTML_Style_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "style", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLStyleElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vmedia;
  Document doc;
  doc = (Document) load("style", false);
  nodeList = doc.getElementsByTagName("style");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vmedia = ((HTMLStyleElement) /*Node */testNode).getMedia();
  assertEquals("screen", vmedia, "mediaLink");
 }
}