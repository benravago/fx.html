package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createDocument(namespaceURI,qualifiedName,doctype)" method for a 
* DOMImplementation should raise WRONG_DOCUMENT_ERR DOMException
* if parameter doctype was created from a different implementation.
* 
* Invoke method createDocument(namespaceURI,qualifiedName,doctype) on
* a domimplementation that is different from this domimplementation.
* Doctype is the type of this document.
* Method should raise WRONG_DOCUMENT_ERR DOMException.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='WRONG_DOCUMENT_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='WRONG_DOCUMENT_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Level-2-Core-DOM-createDocument')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='WRONG_DOCUMENT_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Level-2-Core-DOM-createDocument')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='WRONG_DOCUMENT_ERR'])</a>
*/
class Create_Document_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createDocument04")
 void run() throws Throwable {
  String namespaceURI = "http://www.ecommerce.org/schema";
  String qualifiedName = "namespaceURI:x";
  Document doc;
  DocumentType docType;
  DOMImplementation domImpl;
  Document aNewDoc;
  doc = (Document) load("staffNS", false);
  aNewDoc = (Document) load("staffNS", false);
  docType = doc.getDoctype();
  domImpl = aNewDoc.getImplementation();
  {
   boolean success = false;
   try {
    aNewDoc = domImpl.createDocument(namespaceURI, qualifiedName, docType);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.WRONG_DOCUMENT_ERR);
   }
   assertTrue(success, "throw_WRONG_DOCUMENT_ERR");
  }
 }
}