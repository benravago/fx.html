package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The accessKey attribute is a single character access key to give
* access to the form control. 
* Retrieve the accessKey attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-89647724">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-89647724</a>
*/
class HTML_Anchor_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "anchor", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAnchorElement01")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLAnchorElement testNode;
  String vaccesskey;
  Document doc;
  doc = (Document) load("anchor", false);
  nodeList = doc.getElementsByTagName("a");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = (HTMLAnchorElement) nodeList.item(0);
  vaccesskey = testNode.getAccessKey();
  assertEquals("g", vaccesskey, "accessKeyLink");
 }
}