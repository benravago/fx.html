package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "feature" parameter in the
* isSupported(feature,version)" method is the name
* of the feature and the version is the version number of the
* feature to test.   XXX is NOT a legal value for the feature parameter.
* The method should return "false" since XXX is not a valid feature.
* 
* Retrieve the root node of the DOM document by invoking 
* the "getDocumentElement()" method.   This should create a
* node object on which the "isSupported(feature,version)"
* method is invoked with "feature" equal to "XXX" and version to "1.0".
* The method should return a boolean "false" since XXX is not a valid feature.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports</a>
*/
class Is_Supported_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/isSupported01")
 void run() throws Throwable {
  Document doc;
  Node rootNode;
  boolean state;
  doc = (Document) load("staff", false);
  rootNode = doc.getDocumentElement();
  state = rootNode.isSupported("XXX", "1.0");
  assertFalse(state, "throw_False");
 }
}