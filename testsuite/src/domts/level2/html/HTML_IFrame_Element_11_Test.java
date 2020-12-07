package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the contentDocument attribute of the second IFRAME element
* and examine its title.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-67133006">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-67133006</a>
*/
class HTML_IFrame_Element_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "iframe2", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLIFrameElement11")
 void run() throws Throwable {
  Element testNode;
  Document cd;
  String vtitle;
  Document doc;
  doc = (Document) load("iframe2", false);
  testNode = doc.getElementById("Iframe2");
  cd = ((HTMLIFrameElement) /*Node */testNode).getContentDocument();
  vtitle = ((HTMLDocument) /*Node */cd).getTitle();
  assertEquals("NIST DOM HTML Test - FRAME", vtitle, "titleLink");
 }
}