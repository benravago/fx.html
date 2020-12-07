package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The width attribute specifies the fixed width for content.
* Retrieve the width attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-13894083">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-13894083</a>
*/
class HTML_Pre_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "pre", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLPreElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vwidth;
  Document doc;
  doc = (Document) load("pre", false);
  nodeList = doc.getElementsByTagName("pre");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vwidth = (int) ((HTMLPreElement) /*Node */testNode).getWidth();
  assertEquals(277, vwidth, "widthLink");
 }
}