package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The importNode method imports a node from another document to this document. 
* A NOT_SUPPORTED_ERR is raised if the type of node being imported is
* not supported
* 
* Using the method importNode with deep=true, try to import this Document's 
* DocumentType object. Since DocumentType nodes cannot be imported, a 
* NOT_SUPPORTED_ERR should be raised.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Document_Import_Node_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode07")
 void run() throws Throwable {
  Document doc;
  Node imported;
  DocumentType docType;
  doc = (Document) load("staffNS", true);
  docType = doc.getDoctype();
  {
   boolean success = false;
   try {
    imported = doc.importNode(docType, true);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NOT_SUPPORTED_ERR);
   }
   assertTrue(success, "throw_NOT_SUPPORTED_ERR");
  }
 }
}