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
* Using the method importNode with deep=false, import a newly created DocumentFragment node
* with the first address element from this Document appended to it into this document. 
* Since deep=false, an empty DocumentFragment should be returned 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Document_Import_Node_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode09")
 void run() throws Throwable {
  Document doc;
  DocumentFragment docFragment;
  NodeList childList;
  boolean success;
  Node addressNode;
  Node appendedChild;
  Node importedDocFrag;
  doc = (Document) load("staffNS", true);
  docFragment = doc.createDocumentFragment();
  childList = doc.getElementsByTagNameNS("*", "address");
  addressNode = childList.item(0);
  appendedChild = docFragment.appendChild(addressNode);
  importedDocFrag = doc.importNode(docFragment, false);
  success = importedDocFrag.hasChildNodes();
  assertFalse(success, "documentimportnode09");
 }
}