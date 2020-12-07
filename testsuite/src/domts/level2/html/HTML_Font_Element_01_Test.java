package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The color attribute specifies the font's color. 
* Retrieve the color attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-53532975">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-53532975</a>
*/
class HTML_Font_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "font", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFontElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcolor;
  Document doc;
  doc = (Document) load("font", false);
  nodeList = doc.getElementsByTagName("font");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcolor = ((HTMLFontElement) /*Node */testNode).getColor();
  assertEquals("#000000", vcolor, "colorLink");
 }
}