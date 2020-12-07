package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createDocumentType(qualifiedName,publicId,systemId)" method for a 
* DOMImplementation should raise NAMESPACE_ERR DOMException if
* qualifiedName is malformed.
* 
* Retrieve the DOMImplementation on the XMLNS Document.
* Invoke method createDocumentType(qualifiedName,publicId,systemId)
* on the retrieved DOMImplementation with qualifiedName being the literal
* string "prefix::local", publicId as "STAFF", and systemId as "staff".
* Method should raise NAMESPACE_ERR DOMException.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Level-2-Core-DOM-createDocType')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Level-2-Core-DOM-createDocType')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])</a>
*/
class Create_DocumentType_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createDocumentType01")
 void run() throws Throwable {
  String publicId = "STAFF";
  String systemId = "staff.xml";
  String malformedName = "prefix::local";
  Document doc;
  DOMImplementation domImpl;
  DocumentType newType;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  {
   boolean success = false;
   try {
    newType = domImpl.createDocumentType(malformedName, publicId, systemId);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "throw_NAMESPACE_ERR");
  }
 }
}