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
* Using the method importNode with deep=false, try to import this document object to itself. 
* Since Document nodes cannot be imported, a NOT_SUPPORTED_ERR should be raised.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Document_Import_Node_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode06")
 void run() throws Throwable {
  Document doc;
  Document docImported;
  doc = (Document) load("staffNS", true);
  {
   boolean success = false;
   try {
    docImported = (Document) doc.importNode(doc, false);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NOT_SUPPORTED_ERR);
   }
   assertTrue(success, "throw_NOT_SUPPORTED_ERR");
  }
 }
}