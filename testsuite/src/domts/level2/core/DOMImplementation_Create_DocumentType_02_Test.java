package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method createDocumentType with valid values for qualifiedName, publicId and
* systemId should create an empty DocumentType node.
* 
* Invoke createDocument on this DOMImplementation with a different valid qualifiedNames 
* and a valid publicId and systemId.  Check if the the DocumentType node was created 
* with its ownerDocument attribute set to null.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType</a>
*/
class DOMImplementation_Create_DocumentType_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/domimplementationcreatedocumenttype02")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  DocumentType newDocType;
  Document ownerDocument;
  String publicId = "http://www.w3.org/DOM/Test/dom2.dtd";
  String systemId = "dom2.dtd";
  String qualifiedName;
  List qualifiedNames = new ArrayList();
  qualifiedNames.add("_:_");
  qualifiedNames.add("_:h0");
  qualifiedNames.add("_:test");
  qualifiedNames.add("_:_.");
  qualifiedNames.add("_:a-");
  qualifiedNames.add("l_:_");
  qualifiedNames.add("ns:_0");
  qualifiedNames.add("ns:a0");
  qualifiedNames.add("ns0:test");
  qualifiedNames.add("ns:EEE.");
  qualifiedNames.add("ns:_-");
  qualifiedNames.add("a.b:c");
  qualifiedNames.add("a-b:c.j");
  qualifiedNames.add("a-b:c");
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  for (int indexN10077 = 0; indexN10077 < qualifiedNames.size(); indexN10077++) {
   qualifiedName = (String) qualifiedNames.get(indexN10077);
   newDocType = domImpl.createDocumentType(qualifiedName, publicId, systemId);
   assertNotNull(newDocType, "domimplementationcreatedocumenttype02_newDocType");
   ownerDocument = newDocType.getOwnerDocument();
   assertNull(ownerDocument, "domimplementationcreatedocumenttype02_ownerDocument");
  }
 }
}