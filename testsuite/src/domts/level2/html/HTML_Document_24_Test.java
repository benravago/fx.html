package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Checks that Node.isSupported("xhTmL", null) returns true if hasFeature("XML", null) is true.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-26809268">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-26809268</a>
*/
class HTML_Document_24_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument24")
 void run() throws Throwable {
  Document doc;
  boolean state;
  boolean hasXML;
  String version = null;
  doc = (Document) load("document", true);
  hasXML = doc.isSupported("XML", version);
  state = doc.isSupported("xhTmL", version);
  assertEquals(hasXML, state, "isSupportedXHTML");
 }
}