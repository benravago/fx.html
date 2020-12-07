package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Clears the current document using HTMLDocument.open immediately followed by close.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-72161170">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-72161170</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-98948567">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-98948567</a>
*/
class HTML_Document_17_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument17")
 void run() throws Throwable {
  Document doc;
  Element bodyElem;
  Node bodyChild;
  doc = (Document) load("document", true);
  ((HTMLDocument) /*Node */doc).open();
  ((HTMLDocument) /*Node */doc).close();
  bodyElem = ((HTMLDocument) /*Node */doc).getBody();
  if ((bodyElem != null)) {
   bodyChild = bodyElem.getFirstChild();
   assertNull(bodyChild, "bodyContainsChildren");
  }
 }
}