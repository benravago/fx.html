package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Calls HTMLDocument.close on a document that has not been opened for modification.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-98948567">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-98948567</a>
*/
class HTML_Document_18_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument18")
 void run() throws Throwable {
  Document doc;
  doc = (Document) load("document", true);
  ((HTMLDocument) /*Node */doc).close();
 }
}