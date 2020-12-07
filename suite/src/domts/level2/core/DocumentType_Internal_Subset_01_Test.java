package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getInternalSubset() returns the internal subset as a string. 
* 
* Create a new DocumentType node with null values for publicId and systemId.
* Verify that its internal subset is null.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-internalSubset">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-internalSubset</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class DocumentType_Internal_Subset_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documenttypeinternalSubset01")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  DOMImplementation domImpl;
  String internal;
  String nullNS = null;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  docType = domImpl.createDocumentType("l2:root", nullNS, nullNS);
  internal = docType.getInternalSubset();
  assertNull(internal, "internalSubsetNull");
 }
}