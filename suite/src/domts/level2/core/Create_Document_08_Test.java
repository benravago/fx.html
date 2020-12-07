package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* DOMImplementation.createDocument with an empty qualified name should cause an INVALID_CHARACTER_ERR.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#">http://www.w3.org/TR/DOM-Level-2-Core/core#</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=525">http://www.w3.org/Bugs/Public/show_bug.cgi?id=525</a>
*/
@Disabled("2")
class Create_Document_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createDocument08")
 void run() throws Throwable {
  String namespaceURI = "http://www.example.org/schema";
  DocumentType docType = null;
  DOMImplementation domImpl;
  Document aNewDoc;
  String charact;
  domImpl = getImplementation();
  {
   boolean success = false;
   try {
    aNewDoc = domImpl.createDocument(namespaceURI, "", docType);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
   }
   assertTrue(success, "throw_INVALID_CHARACTER_ERR");
  }
 }
}