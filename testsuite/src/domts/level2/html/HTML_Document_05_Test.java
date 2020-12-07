package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The body attribute is the element that contains the content for the
* document.
* Retrieve the body attribute and examine its value for the id attribute.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-56360201">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-56360201</a>
*/
class HTML_Document_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument05")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLElement vbody;
  String vid;
  Document doc;
  doc = (Document) load("document", false);
  vbody = ((HTMLDocument) /*Node */doc).getBody();
  vid = vbody.getId();
  assertEquals("TEST-BODY", vid, "idLink");
 }
}