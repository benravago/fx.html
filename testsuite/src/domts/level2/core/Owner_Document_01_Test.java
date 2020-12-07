package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getOwnerDocument()" method returns null if the target
* node itself is a DocumentType which is not used with any document yet.
* 
* Invoke the "getOwnerDocument()" method on the master 
* document.   The DocumentType returned should be null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#node-ownerDoc">http://www.w3.org/TR/DOM-Level-2-Core/core#node-ownerDoc</a>
*/
class Owner_Document_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/ownerDocument01")
 void run() throws Throwable {
  Document doc;
  DocumentType ownerDocument;
  doc = (Document) load("staff", false);
  ownerDocument = (DocumentType) doc.getOwnerDocument();
  assertNull(ownerDocument, "throw_Null");
 }
}