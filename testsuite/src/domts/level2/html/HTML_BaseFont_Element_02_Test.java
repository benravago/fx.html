package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The face attribute specifies the base font's face identifier. 
* Retrieve the face attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-88128969">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-88128969</a>
*/
class HTML_BaseFont_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "basefont", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLBaseFontElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vface;
  Document doc;
  doc = (Document) load("basefont", false);
  nodeList = doc.getElementsByTagName("basefont");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vface = ((HTMLBaseFontElement) /*Node */testNode).getFace();
  assertEquals("arial,helvitica", vface, "faceLink");
 }
}