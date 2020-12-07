package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createDocument(namespaceURI,qualifiedName,doctype)" method for a 
* DOMImplementation should raise NAMESPACE_ERR DOMException
* if qualifiedName has a prefix and namespaceURI is null.
* 
* Invoke method createDocument(namespaceURI,qualifiedName,doctype) on
* this domimplementation with namespaceURI being null and qualifiedName
* equals "k:local". Method should raise NAMESPACE_ERR DOMException.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Level-2-Core-DOM-createDocument')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Level-2-Core-DOM-createDocument')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])</a>
*/
class Create_Document_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createDocument02")
 void run() throws Throwable {
  String namespaceURI = null;
  String qualifiedName = "k:local";
  Document doc;
  DocumentType docType = null;
  DOMImplementation domImpl;
  Document aNewDoc;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  {
   boolean success = false;
   try {
    aNewDoc = domImpl.createDocument(namespaceURI, qualifiedName, docType);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "throw_NAMESPACE_ERR");
  }
 }
}