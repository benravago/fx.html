package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method "isSupported(feature,version)" Tests whether the DOM implementation 
* implements a specific feature and that feature is supported by this node. 
* 
* Call the isSupported method specifying empty strings for feature and version on a 
* new EntityReference node.  Check if the value returned value was false.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-Node-supports</a>
*/
class Node_Is_Supported_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodeissupported04")
 void run() throws Throwable {
  Document doc;
  EntityReference entRef;
  boolean success;
  doc = (Document) load("staffNS", false);
  entRef = doc.createEntityReference("ent1");
  assertNotNull(entRef, "createdEntRefNotNull");
  success = entRef.isSupported("XML CORE", "");
  assertFalse(success, "nodeissupported04");
 }
}