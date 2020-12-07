package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The links attribute returns a collection of all AREA and A elements
* in a document with a value for the href attribute.
* Retrieve the links attribute from the document and examine its value.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-7068919">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-7068919</a>
*/
class HTML_Document_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument09")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLCollection vlinks;
  int vlength;
  Document doc;
  doc = (Document) load("document", false);
  vlinks = ((HTMLDocument) /*Node */doc).getLinks();
  vlength = (int) vlinks.getLength();
  assertEquals(3, vlength, "lengthLink");
 }
}