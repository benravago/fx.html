package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method "hasFeature(feature,version)" tests if the DOMImplementation implements
* a specific feature and if not returns false.
* 
* Call the hasFeature method on this DOMImplementation with a unfimiliar values for 
* feature and version.  Check if the value returned was false.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-5CED94D7">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-5CED94D7</a>
*/
class DOMImplementation_Has_Feature_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/domimplementationhasfeature02")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  boolean success;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  success = domImpl.hasFeature("Blah Blah", "");
  assertFalse(success, "domimplementationhasfeature02");
 }
}