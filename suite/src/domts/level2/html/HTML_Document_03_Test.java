package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The domain attribute specifies the domain name of the server that served
* the document, or null if the server cannot be identified by a domain name.
* Retrieve the domain attribute and examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-2250147">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-2250147</a>
*/
class HTML_Document_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vdomain;
  Document doc;
  doc = (Document) load("document", false);
  vdomain = ((HTMLDocument) /*Node */doc).getDomain();
  assertEquals("", vdomain, "domainLink");
 }
}