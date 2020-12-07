package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The cookie attribute returns the cookies associated with this document.
* Retrieve the cookie attribute and examine its value.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-8747038">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-8747038</a>
*/
class HTML_Document_12_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument12")
 void run() throws Throwable {
  NodeList nodeList;
  String vcookie;
  Document doc;
  doc = (Document) load("document", false);
  vcookie = ((HTMLDocument) /*Node */doc).getCookie();
  assertEquals("", vcookie, "cookieLink");
 }
}