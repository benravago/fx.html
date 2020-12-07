package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The start attribute specifies the starting sequence number.        
* Retrieve the start attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-14793325">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-14793325</a>
*/
class HTML_OList_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "olist", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLOListElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vstart;
  Document doc;
  doc = (Document) load("olist", false);
  nodeList = doc.getElementsByTagName("ol");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vstart = (int) ((HTMLOListElement) /*Node */testNode).getStart();
  assertEquals(1, vstart, "startLink");
 }
}