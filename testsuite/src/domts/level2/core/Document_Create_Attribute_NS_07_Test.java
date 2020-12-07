package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method createAttributeNS raises a NAMESPACE_ERR if the qualifiedName is xmlns and 
* the namespaceURI is different from http://www.w3.org/2000/xmlns
* 
* Invoke the createAttributeNS method on this DOMImplementation object with  
* the qualifiedName as xmlns and namespaceURI as http://www.W3.org/2000/xmlns.  
* Check if the NAMESPACE_ERR exception is thrown.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS</a>
*/
class Document_Create_Attribute_NS_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentcreateattributeNS07")
 void run() throws Throwable {
  Document doc;
  Attr attribute;
  String namespaceURI = "http://www.W3.org/2000/xmlns";
  String qualifiedName = "xmlns";
  doc = (Document) load("staffNS", false);
  {
   boolean success = false;
   try {
    attribute = doc.createAttributeNS(namespaceURI, qualifiedName);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "documentcreateattributeNS07");
  }
 }
}