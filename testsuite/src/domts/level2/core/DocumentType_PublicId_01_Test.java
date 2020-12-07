package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getInternalSubset() returns the public identifier of the external subset.
* 
* Create a new DocumentType node with the value "PUB" for its publicId.
* Check the value of the publicId attribute using getPublicId().
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-publicId">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-publicId</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class DocumentType_PublicId_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documenttypepublicid01")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  DOMImplementation domImpl;
  String publicId;
  String nullNS = null;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  docType = domImpl.createDocumentType("l2:root", "PUB", nullNS);
  publicId = docType.getPublicId();
  assertEquals("PUB", publicId, "documenttypepublicid01");
 }
}