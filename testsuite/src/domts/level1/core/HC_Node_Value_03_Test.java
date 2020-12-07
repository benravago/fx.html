package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* An entity reference is created, setNodeValue is called with a non-null argument, but getNodeValue
* should still return null.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-11C98490">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-11C98490</a>
*/
class HC_Node_Value_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodevalue03")
 void run() throws Throwable {
  Document doc;
  Node newNode;
  String newValue;
  doc = (Document) load("hc_staff", true);
  if (("text/html".equals(getContentType()))) {
   {
    boolean success = false;
    try {
     newNode = doc.createEntityReference("ent1");
    } catch (DOMException ex) {
     success = (ex.code == DOMException.NOT_SUPPORTED_ERR);
    }
    assertTrue(success, "throw_NOT_SUPPORTED_ERR");
   }
  } else {
   newNode = doc.createEntityReference("ent1");
   assertNotNull(newNode, "createdEntRefNotNull");
   newValue = newNode.getNodeValue();
   assertNull(newValue, "initiallyNull");
   newNode.setNodeValue("This should have no effect");
   newValue = newNode.getNodeValue();
   assertNull(newValue, "nullAfterAttemptedChange");
  }
 }
}