package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The longDesc attribute specifies a URI designating a long description
* of this image or frame.
* Retrieve the longDesc attribute of the first FRAME element and examine
* its value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-7836998">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-7836998</a>
*/
class HTML_Frame_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "frame", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFrameElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vlongdesc;
  Document doc;
  doc = (Document) load("frame", false);
  nodeList = doc.getElementsByTagName("frame");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vlongdesc = ((HTMLFrameElement) /*Node */testNode).getLongDesc();
  assertEquals("about:blank", vlongdesc, "longdescLink");
 }
}