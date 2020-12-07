package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The tabIndex attribute is an index that represents the elements position
* in the tabbing order.
* Retrieve the tabIndex attribute of the 3rd INPUT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-62176355">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-62176355</a>
*/
class HTML_Input_Element_15_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement15")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vtabindex;
  Document doc;
  doc = (Document) load("input", false);
  nodeList = doc.getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(2);
  vtabindex = (int) ((HTMLInputElement) /*Node */testNode).getTabIndex();
  assertEquals(9, vtabindex, "tabindexLink");
 }
}