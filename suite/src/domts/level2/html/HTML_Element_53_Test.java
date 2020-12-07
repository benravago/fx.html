package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The title attribute specifies the elements advisory title. 
* Retrieve the title attribute of the DD element and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-78276800">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-78276800</a>
*/
class HTML_Element_53_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "element", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLElement53")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vtitle;
  Document doc;
  doc = (Document) load("element", false);
  nodeList = doc.getElementsByTagName("dd");
  assertTrue(equalsSize(4, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtitle = ((HTMLElement) /*Node */testNode).getTitle();
  assertEquals("DD Element", vtitle, "titleLink");
 }
}