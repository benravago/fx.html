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
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-62018039">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-62018039</a>
*/
class HTML_Body_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLBodyElement09")
 void run() throws Throwable {
  Document doc;
  Element body;
  boolean state;
  boolean hasXML;
  String version = null;
  doc = (Document) load("document", false);
  body = ((HTMLDocument) /*Node */doc).getBody();
  hasXML = body.isSupported("XML", version);
  state = body.isSupported("xhTmL", version);
  assertEquals(hasXML, state, "isSupportedXHTML");
 }
}