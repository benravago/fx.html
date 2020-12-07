package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The createDocument method should raise a NAMESPACE_ERR if the qualifiedName is malformed 
* 
* Invoke the createDocument method on this DOMImplementation object with null values
* for namespaceURI and docType and a malformed qualifiedName.  
* The NAMESPACE_ERR should be raised. 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument</a>
*/
class DOMImplementation_Create_Document_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/domimplementationcreatedocument07")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  Document newDoc;
  String namespaceURI = "http://www.w3.org/DOMTest/level2";
  DocumentType docType = null;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  {
   boolean success = false;
   try {
    newDoc = domImpl.createDocument(namespaceURI, ":", docType);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "domimplementationcreatedocument07");
  }
 }
}