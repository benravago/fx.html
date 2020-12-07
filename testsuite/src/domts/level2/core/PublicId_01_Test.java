package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getPublicId()" method of a documenttype node contains
* the public identifier associated with the external subset.
* 
* Retrieve the documenttype.
* Apply the "getPublicId()" method.  The string "STAFF" should be
* returned.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-publicId">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-publicId</a>
*/
class PublicId_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/publicId01")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  String publicId;
  doc = (Document) load("staffNS", false);
  docType = doc.getDoctype();
  publicId = docType.getPublicId();
  assertEquals("STAFF", publicId, "throw_Equals");
 }
}