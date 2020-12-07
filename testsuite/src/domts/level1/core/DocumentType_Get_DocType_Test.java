package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getName()" method contains the name of the DTD. 
* 
* Retrieve the Document Type for this document and examine
* the string returned by the "getName()" method.
* It should be set to "staff".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A31">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A31</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1844763134">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1844763134</a>
*/
@Disabled("fx")
class DocumentType_Get_DocType_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documenttypegetdoctype")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  String name;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  name = docType.getName();
  if (("image/svg+xml".equals(getContentType()))) {
   assertEquals("svg", name, "doctypeName");
  } else {
   assertEquals("staff", name, "documenttypeGetDocTypeAssert");
  }
 }
}