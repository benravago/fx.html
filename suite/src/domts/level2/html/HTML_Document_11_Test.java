package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The anchors attribute returns a collection of all A elements with values
* for the name attribute.
* Retrieve the anchors attribute from the document and examine its value.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-7577272">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-7577272</a>
*/
class HTML_Document_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument11")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLCollection vanchors;
  int vlength;
  Document doc;
  doc = (Document) load("document", false);
  vanchors = ((HTMLDocument) /*Node */doc).getAnchors();
  vlength = (int) vanchors.getLength();
  assertEquals(1, vlength, "lengthLink");
 }
}