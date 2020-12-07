package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method createDocumentType with valid values for qualifiedName, publicId and
* systemId should create an empty DocumentType node.
* 
* Invoke createDocument on this DOMImplementation with a valid qualifiedName and different
* publicIds and systemIds.  Check if the the DocumentType node was created with its 
* ownerDocument attribute set to null.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument</a>
*/
class DOMImplementation_Create_DocumentType_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/domimplementationcreatedocumenttype01")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  DocumentType newDocType;
  Document ownerDocument;
  String qualifiedName = "test:root";
  String publicId;
  String systemId;
  List publicIds = new ArrayList();
  publicIds.add("1234");
  publicIds.add("test");
  List systemIds = new ArrayList();
  systemIds.add("");
  systemIds.add("test");
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  for (int indexN1005D = 0; indexN1005D < publicIds.size(); indexN1005D++) {
   publicId = (String) publicIds.get(indexN1005D);
   for (int indexN10061 = 0; indexN10061 < systemIds.size(); indexN10061++) {
    systemId = (String) systemIds.get(indexN10061);
    newDocType = domImpl.createDocumentType(qualifiedName, publicId, systemId);
    assertNotNull(newDocType, "domimplementationcreatedocumenttype01_newDocType");
    ownerDocument = newDocType.getOwnerDocument();
    assertNull(ownerDocument, "domimplementationcreatedocumenttype01_ownerDocument");
   }
  }
 }
}