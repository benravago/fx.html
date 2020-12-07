package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The dir attribute specifies the base direction of directionally neutral text and the directionality of tables. 
* Retrieve the dir attribute of the ACRONYM element and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-52460740">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-52460740</a>
*/
class HTML_Element_109_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "element", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLElement109")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vdir;
  Document doc;
  doc = (Document) load("element", false);
  nodeList = doc.getElementsByTagName("acronym");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vdir = ((HTMLElement) /*Node */testNode).getDir();
  assertEquals("ltr", vdir, "dirLink");
 }
}