package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The createDocument method should throw a NAMESPACE_ERR if the qualifiedName has 
* a prefix that is xml and the namespaceURI is different from 
* http://www..w3.org/XML/1998/namespace.
* 
* Call the createDocument on this DOMImplementation with namespaceURI that is 
* http://www.w3.org/xml/1998/namespace and a qualifiedName that has the prefix xml
* Check if the NAMESPACE_ERR is thrown.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument</a>
*/
class DOMImplementation_Create_Document_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/domimplementationcreatedocument05")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  Document newDoc;
  String namespaceURI = "http://www.w3.org/xml/1998/namespace";
  String qualifiedName = "xml:root";
  DocumentType docType = null;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  {
   boolean success = false;
   try {
    newDoc = domImpl.createDocument(namespaceURI, qualifiedName, docType);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "domimplementationcreatedocument05");
  }
 }
}