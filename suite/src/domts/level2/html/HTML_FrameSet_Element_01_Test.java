package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The cols attribute specifies the number of columns of frames in the    
* frameset.
* Retrieve the cols attribute of the first FRAMESET element and examine
* it's value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-98869594">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-98869594</a>
*/
class HTML_FrameSet_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "frameset", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFrameSetElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcols;
  Document doc;
  doc = (Document) load("frameset", false);
  nodeList = doc.getElementsByTagName("frameset");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcols = ((HTMLFrameSetElement) /*Node */testNode).getCols();
  assertEquals("20, 80", vcols, "colsLink");
 }
}