package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The size attribute specifies the number of visible rows.
* Retrieve the size attribute from the first SELECT element and 
* examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-18293826">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-18293826</a>
*/
class HTML_Select_Element_12_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "select", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLSelectElement12")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vsize;
  Document doc;
  doc = (Document) load("select", false);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  vsize = (int) ((HTMLSelectElement) /*Node */testNode).getSize();
  assertEquals(1, vsize, "sizeLink");
 }
}