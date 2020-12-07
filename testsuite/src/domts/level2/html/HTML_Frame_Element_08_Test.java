package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The src attribute specifies a URI designating the initial frame contents.
* Retrieve the src attribute of the first FRAME element and examine
* it's value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-78799535">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-78799535</a>
*/
class HTML_Frame_Element_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "frame", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFrameElement08")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vsrc;
  Document doc;
  doc = (Document) load("frame", false);
  nodeList = doc.getElementsByTagName("frame");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vsrc = ((HTMLFrameElement) /*Node */testNode).getSrc();
  assertTrue(equalsURI(null, null, null, null, "right", null, null, null, vsrc), "srcLink");
 }
}