package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getInternalSubset() returns the public identifier of the external subset.
* 
* Create a new DocumentType node with the value "SYS" for its systemId and PUB for
* its publicId.  Check the value of the systemId and pbulicId attributes.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-systemId">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-systemId</a>
*/
class DocumentType_SystemId_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documenttypesystemid01")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  DOMImplementation domImpl;
  String publicId;
  String systemId;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  docType = domImpl.createDocumentType("l2:root", "PUB", "SYS");
  publicId = docType.getPublicId();
  systemId = docType.getSystemId();
  assertEquals("PUB", publicId, "documenttypepublicid01");
  assertEquals("SYS", systemId, "documenttypesystemid01");
 }
}