package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The importNode method imports a node from another document to this document. 
* The returned node has no parent; (parentNode is null). The source node is not 
* altered or removed from the original document but a new copy of the source node
* is created.
* 
* Using the method importNode with deep=true, import a newly created Text node for this
* Document.  Verify if the node has been imported correctly by checking the value of the 
* imported text node.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Document_Import_Node_15_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode15")
 void run() throws Throwable {
  Document doc;
  Document docImp;
  Node textImport;
  Node textToImport;
  String nodeValue;
  doc = (Document) load("staffNS", true);
  docImp = (Document) load("staffNS", true);
  textToImport = doc.createTextNode("Document.importNode test for a TEXT_NODE");
  textImport = doc.importNode(textToImport, true);
  nodeValue = textImport.getNodeValue();
  assertEquals("Document.importNode test for a TEXT_NODE", nodeValue, "documentimportnode15");
 }
}