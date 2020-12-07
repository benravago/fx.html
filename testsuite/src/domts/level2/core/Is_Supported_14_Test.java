package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Calls isSupported("Core",null) should return true for all implementations (by extension of core-14).
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports</a>
* @see <a href="http://www.w3.org/2000/11/DOM-Level-2-errata#core-14">http://www.w3.org/2000/11/DOM-Level-2-errata#core-14</a>
*/
class Is_Supported_14_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/isSupported14")
 void run() throws Throwable {
  Document doc;
  Node rootNode;
  boolean state;
  String nullString = null;
  doc = (Document) load("staff", false);
  rootNode = doc.getDocumentElement();
  state = rootNode.isSupported("Core", nullString);
  assertTrue(state, "Core");
 }
}