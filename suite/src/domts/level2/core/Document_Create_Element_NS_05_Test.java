package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method createElementNS raises a NAMESPACE_ERR if the qualifiedName has a prefix and 
* the namespaceURI is null.
* 
* Invoke the createElementNS method on a new Document object with a null value for 
* namespaceURI, and a valid qualifiedName.  Check if a NAMESPACE_ERR is thrown.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrElNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrElNS</a>
*/
class Document_Create_Element_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentcreateelementNS05")
 void run() throws Throwable {
  Document doc;
  Element element;
  String namespaceURI = null;
  String qualifiedName = "null:xml";
  doc = (Document) load("staffNS", false);
  {
   boolean success = false;
   try {
    element = doc.createElementNS(namespaceURI, qualifiedName);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "documentcreateelementNS05");
  }
 }
}