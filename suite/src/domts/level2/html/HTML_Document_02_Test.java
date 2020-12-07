package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The referrer attribute returns the URI of the page that linked to this
* page.
* Retrieve the referrer attribute and examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-95229140">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-95229140</a>
*/
class HTML_Document_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vreferrer;
  Document doc;
  doc = (Document) load("document", false);
  vreferrer = ((HTMLDocument) /*Node */doc).getReferrer();
  assertEquals("", vreferrer, "referrerLink");
 }
}