package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The vLink attribute specifies the color of links that have been
* visited by the user. 
* Retrieve the vLink attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-83224305">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-83224305</a>
*/
class HTML_Body_Element_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "body", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLBodyElement06")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vvlink;
  Document doc;
  doc = (Document) load("body", false);
  nodeList = doc.getElementsByTagName("body");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvlink = ((HTMLBodyElement) /*Node */testNode).getVLink();
  assertEquals("#00ffff", vvlink, "vLinkLink");
 }
}