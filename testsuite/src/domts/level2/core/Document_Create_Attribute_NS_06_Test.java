package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method createAttributeNS raises a NAMESPACE_ERR if the qualifiedName has a prefix that 
* is "xml" and the namespaceURI is different from "http://www.w3.org/XML/1998/namespace".
* 
* Invoke the createAttributeNS method on a new DOMImplementation object with  the qualifiedName 
* as xml:root and namespaceURI as http://www.w3.org/XML/1998 /namespace.
* Check if the NAMESPACE_ERR exception is thrown.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS</a>
*/
class Document_Create_Attribute_NS_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentcreateattributeNS06")
 void run() throws Throwable {
  Document doc;
  Document newDoc;
  DocumentType docType = null;
  DOMImplementation domImpl;
  Attr attribute;
  String namespaceURI = "http://www.w3.org/XML/1998 /namespace";
  String qualifiedName = "xml:root";
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  newDoc = domImpl.createDocument("http://www.w3.org/DOM/Test", "dom:doc", docType);
  {
   boolean success = false;
   try {
    attribute = newDoc.createAttributeNS(namespaceURI, qualifiedName);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "documentcreateattributeNS06");
  }
 }
}