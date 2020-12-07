package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "feature" parameter in the
* isSupported(feature,version)" method is the name
* of the feature and the version is the version number of the
* feature to test.   CORE is a legal value for the feature parameter 
* (Test for CORE, upper case). 
* Legal values for the version parameter are 1.0 and 2.0
* (Test for 1.0).
* 
* Retrieve the root node of the DOM document by invoking 
* the "getDocumentElement()" method.   This should create a
* node object on which the "isSupported(feature,version)"
* method is invoked with "feature" equal to "CORE" and the version equal to 1.0.
* The method should return a boolean "true".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports</a>
*/
class Is_Supported_12_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/isSupported12")
 void run() throws Throwable {
  List features = new ArrayList();
  features.add("Core");
  features.add("XML");
  features.add("HTML");
  features.add("Views");
  features.add("StyleSheets");
  features.add("CSS");
  features.add("CSS2");
  features.add("Events");
  features.add("UIEvents");
  features.add("MouseEvents");
  features.add("MutationEvents");
  features.add("HTMLEvents");
  features.add("Range");
  features.add("Traversal");
  features.add("bogus.bogus.bogus");
  Document doc;
  Node rootNode;
  String featureElement;
  boolean state;
  doc = (Document) load("staff", false);
  rootNode = doc.getDocumentElement();
  state = rootNode.isSupported("Core", "2.0");
  assertTrue(state, "Core2");
  for (int indexN10078 = 0; indexN10078 < features.size(); indexN10078++) {
   featureElement = (String) features.get(indexN10078);
   state = rootNode.isSupported(featureElement, "1.0");
  }
  for (int indexN10083 = 0; indexN10083 < features.size(); indexN10083++) {
   featureElement = (String) features.get(indexN10083);
   state = rootNode.isSupported(featureElement, "2.0");
  }
 }
}