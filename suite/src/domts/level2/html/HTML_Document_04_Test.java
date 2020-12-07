package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The URL attribute specifies the absolute URI of the document.        
* Retrieve the URL attribute and examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-46183437">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-46183437</a>
*/
class HTML_Document_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vurl;
  Document doc;
  doc = (Document) load("document", false);
  vurl = ((HTMLDocument) /*Node */doc).getURL();
  assertTrue(equalsURI(null, null, null, null, "document", null, null, Boolean.TRUE, vurl), "URLLink");
 }
}