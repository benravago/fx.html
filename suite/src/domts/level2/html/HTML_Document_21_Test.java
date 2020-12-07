package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Replaces the current document checks that writeln adds a new line.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-72161170">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-72161170</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-98948567">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-98948567</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-75233634">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-75233634</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-35318390">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-35318390</a>
*/
class HTML_Document_21_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument21")
 void run() throws Throwable {
  Document doc;
  Element docElem;
  NodeList preElems;
  Element preElem;
  Text preText;
  String preValue;
  doc = (Document) load("document", true);
  ((HTMLDocument) /*Node */doc).open();
  if (("text/html".equals(getContentType()))) {
   ((HTMLDocument) /*Node */doc).writeln("<html>");
  } else {
   ((HTMLDocument) /*Node */doc).writeln("<html xmlns='http://www.w3.org/1999/xhtml'>");
  }
  ((HTMLDocument) /*Node */doc).writeln("<body>");
  ((HTMLDocument) /*Node */doc).writeln("<title>Replacement</title>");
  ((HTMLDocument) /*Node */doc).writeln("</body>");
  ((HTMLDocument) /*Node */doc).write("<pre>");
  ((HTMLDocument) /*Node */doc).writeln("Hello, World.");
  ((HTMLDocument) /*Node */doc).writeln("Hello, World.");
  ((HTMLDocument) /*Node */doc).writeln("</pre>");
  ((HTMLDocument) /*Node */doc).write("<pre>");
  ((HTMLDocument) /*Node */doc).write("Hello, World.");
  ((HTMLDocument) /*Node */doc).write("Hello, World.");
  ((HTMLDocument) /*Node */doc).writeln("</pre>");
  ((HTMLDocument) /*Node */doc).writeln("</body>");
  ((HTMLDocument) /*Node */doc).writeln("</html>");
  ((HTMLDocument) /*Node */doc).close();
 }
}