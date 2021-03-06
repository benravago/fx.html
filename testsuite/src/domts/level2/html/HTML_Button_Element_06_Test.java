package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The tabIndex attribute specifies an index that represents the element's
* position in the tabbing order. 
* Retrieve the tabIndex attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39190908">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39190908</a>
*/
class HTML_Button_Element_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "button", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLButtonElement06")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vtabindex;
  Document doc;
  doc = (Document) load("button", false);
  nodeList = doc.getElementsByTagName("button");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtabindex = (int) ((HTMLButtonElement) /*Node */testNode).getTabIndex();
  assertEquals(20, vtabindex, "tabIndexLink");
 }
}