package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "feature" parameter in the
* isSupported(feature,version)" method is the name
* of the feature and the version is the version number of the
* feature to test.   XML is a legal value for the feature parameter
* (Test for XML). 
* If the version is not specified, supporting any version of the
* method to return true.
* 
* Retrieve the root node of the DOM document by invoking 
* the "getDocumentElement()" method.   This should create a
* node object on which the "isSupported(feature,version)"
* method is invoked with "feature" equal to "XML" and the version equal blank.
* The method should return a boolean "true".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports</a>
*/
class Is_Supported_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/isSupported07")
 void run() throws Throwable {
  Document doc;
  Node rootNode;
  boolean state;
  doc = (Document) load("staff", false);
  rootNode = doc.getDocumentElement();
  state = rootNode.isSupported("XML", "");
  assertTrue(state, "throw_True");
 }
}