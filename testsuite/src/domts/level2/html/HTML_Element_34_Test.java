package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The title attribute specifies the elements advisory title. 
* Retrieve the title attribute of the BDO element and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-78276800">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-78276800</a>
*/
class HTML_Element_34_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "element", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLElement34")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vtitle;
  Document doc;
  doc = (Document) load("element", false);
  nodeList = doc.getElementsByTagName("bdo");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtitle = ((HTMLElement) /*Node */testNode).getTitle();
  assertEquals("BDO Element", vtitle, "titleLink");
 }
}