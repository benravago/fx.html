package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Replaces the current document with a valid HTML document using HTMLDocument.open, write and close.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-72161170">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-72161170</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-98948567">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-98948567</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-75233634">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-75233634</a>
*/
class HTML_Document_19_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument19")
 void run() throws Throwable {
  Document doc;
  Element docElem;
  String title;
  doc = (Document) load("document", true);
  ((HTMLDocument) /*Node */doc).open();
  if (("text/html".equals(getContentType()))) {
   ((HTMLDocument) /*Node */doc).write("<html>");
  } else {
   ((HTMLDocument) /*Node */doc).write("<html xmlns='http://www.w3.org/1999/xhtml'>");
  }
  ((HTMLDocument) /*Node */doc).write("<body>");
  ((HTMLDocument) /*Node */doc).write("<title>Replacement</title>");
  ((HTMLDocument) /*Node */doc).write("</body>");
  ((HTMLDocument) /*Node */doc).write("<p>");
  ((HTMLDocument) /*Node */doc).write("Hello, World.");
  ((HTMLDocument) /*Node */doc).write("</p>");
  ((HTMLDocument) /*Node */doc).write("</body>");
  ((HTMLDocument) /*Node */doc).write("</html>");
  ((HTMLDocument) /*Node */doc).close();
 }
}