package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getOwnerDocument()" method returns null if the target
* node itself is a document.
* 
* Invoke the "getOwnerDocument()" method on the master 
* document.   The Document returned should be null.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#node-ownerDoc">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#node-ownerDoc</a>
*/
class HC_Node_Get_Owner_Document_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodegetownerdocumentnull")
 void run() throws Throwable {
  Document doc;
  Document ownerDocument;
  doc = (Document) load("hc_staff", false);
  ownerDocument = doc.getOwnerDocument();
  assertNull(ownerDocument, "nodeGetOwnerDocumentNullAssert1");
 }
}