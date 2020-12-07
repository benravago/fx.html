package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The size attribute contains the size information.  Its precise meaning
* is specific to each type of field.
* Retrieve the size attribute of the 1st INPUT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-79659438">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-79659438</a>
*/
class HTML_Input_Element_13_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement13")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vsize;
  Node doc;
  doc = (Node) load("input", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(0);
  vsize = Integer.parseInt(((HTMLInputElement) /*Node */testNode).getSize());
  assertEquals(25, vsize, "size");
 }
}