package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The tabIndex attribute specifies the elements position in the tabbing     
* order.
* Retrieve the tabIndex attribute of the first OBJECT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-27083787">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-27083787</a>
*/
class HTML_Object_Element_13_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLObjectElement13")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vtabindex;
  Document doc;
  doc = (Document) load("object", false);
  nodeList = doc.getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtabindex = (int) ((HTMLObjectElement) /*Node */testNode).getTabIndex();
  assertEquals(0, vtabindex, "tabIndexLink");
 }
}