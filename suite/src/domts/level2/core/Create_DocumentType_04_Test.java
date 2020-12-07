package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* DOMImplementation.createDocumentType with an empty name should cause an INVALID_CHARACTER_ERR.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Level-2-Core-DOM-createDocType')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Level-2-Core-DOM-createDocType')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=525">http://www.w3.org/Bugs/Public/show_bug.cgi?id=525</a>
*/
@Disabled("2")
class Create_DocumentType_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createDocumentType04")
 void run() throws Throwable {
  String publicId = "http://www.example.com/";
  String systemId = "myDoc.dtd";
  String qualifiedName;
  DocumentType docType = null;
  DOMImplementation domImpl;
  domImpl = getImplementation();
  {
   boolean success = false;
   try {
    docType = domImpl.createDocumentType("", publicId, systemId);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
   }
   assertTrue(success, "throw_INVALID_CHARACTER_ERR");
  }
 }
}