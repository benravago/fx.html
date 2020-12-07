package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* hasFeature("xhTmL", "2.0") should return true if hasFeature("XML", "2.0") returns true.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-5CED94D7">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-5CED94D7</a>
*/
class Has_Feature_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/hasFeature04")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  String version = "2.0";
  boolean state;
  boolean hasXML;
  domImpl = getImplementation();
  hasXML = domImpl.hasFeature("XML", version);
  state = domImpl.hasFeature("xhTmL", version);
  assertEquals(hasXML, state, "hasXHTML");
 }
}