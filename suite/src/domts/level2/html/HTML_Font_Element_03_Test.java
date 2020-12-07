package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The size attribute specifies the font's size. 
* Retrieve the size attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-90127284">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-90127284</a>
*/
class HTML_Font_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "font", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFontElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vsize;
  Document doc;
  doc = (Document) load("font", false);
  nodeList = doc.getElementsByTagName("font");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vsize = ((HTMLFontElement) /*Node */testNode).getSize();
  assertEquals("4", vsize, "sizeLink");
 }
}