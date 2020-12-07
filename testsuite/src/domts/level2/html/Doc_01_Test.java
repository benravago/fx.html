package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the title attribute of HTMLDocument and examine it's value.  
* @author Netscape
* @author Sivakiran Tummala
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-18446827">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-18446827</a>
*/
class Doc_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "anchor", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/doc01")
 void run() throws Throwable {
  String vtitle;
  Node doc;
  doc = (Node) load("anchor", false);
  vtitle = ((HTMLDocument) /*Node */doc).getTitle();
  assertEquals("NIST DOM HTML Test - Anchor", vtitle, "titleLink");
 }
}