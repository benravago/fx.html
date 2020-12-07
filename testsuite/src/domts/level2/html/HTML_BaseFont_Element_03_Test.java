package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The size attribute specifies the base font's size. 
* Retrieve the size attribute and examine it's value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-38930424">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-38930424</a>
*/
class HTML_BaseFont_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "basefont", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLBaseFontElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vsize;
  Node doc;
  doc = (Node) load("basefont", false);
  nodeList = ((Document) /*Node */doc).getElementsByTagName("basefont");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vsize = Integer.parseInt(((HTMLBaseFontElement) /*Node */testNode).getSize());
  assertEquals(4, vsize, "sizeLink");
 }
}