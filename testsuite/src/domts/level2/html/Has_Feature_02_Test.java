package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* hasFeature("hTmL", "2.0") should return true.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-5CED94D7">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-5CED94D7</a>
*/
class Has_Feature_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/hasFeature02")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  String version = "2.0";
  boolean state;
  domImpl = getImplementation();
  state = domImpl.hasFeature("hTmL", version);
  assertTrue(state, "hasHTML2");
 }
}