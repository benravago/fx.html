package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The noResize attribute specifies if the user can resize the frame.  When
* true, forbid user from resizing frame.
* Retrieve the noResize attribute of the first FRAME element and examine
* it's value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-80766578">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-80766578</a>
*/
class HTML_Frame_Element_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "frame", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFrameElement06")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vnoresize;
  Document doc;
  doc = (Document) load("frame", false);
  nodeList = doc.getElementsByTagName("frame");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vnoresize = ((HTMLFrameElement) /*Node */testNode).getNoResize();
  assertTrue(vnoresize, "noresizeLink");
 }
}