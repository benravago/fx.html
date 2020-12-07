package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The rows attribute specifies the number of rows of frames in the    
* frameset.
* Retrieve the rows attribute of the second FRAMESET element and examine
* it's value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-19739247">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-19739247</a>
*/
class HTML_FrameSet_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "frameset", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFrameSetElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vrows;
  Document doc;
  doc = (Document) load("frameset", false);
  nodeList = doc.getElementsByTagName("frameset");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(1);
  vrows = ((HTMLFrameSetElement) /*Node */testNode).getRows();
  assertEquals("100, 200", vrows, "rowsLink");
 }
}