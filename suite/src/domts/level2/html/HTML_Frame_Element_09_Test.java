package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The contentDocument attribute specifies the document this frame contains,
* if there is any and it is available, or null otherwise.
* Retrieve the contentDocument attribute of the first FRAME element
* and examine its TITLE value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-78799536">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-78799536</a>
*/
class HTML_Frame_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "frame2", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFrameElement09")
 void run() throws Throwable {
  Element testNode;
  Document cd;
  String vtitle;
  Document doc;
  doc = (Document) load("frame2", false);
  testNode = doc.getElementById("Frame1");
  cd = ((HTMLFrameElement) /*Node */testNode).getContentDocument();
  vtitle = ((HTMLDocument) /*Node */cd).getTitle();
  assertEquals("NIST DOM HTML Test - FRAMESET", vtitle, "titleLink");
 }
}