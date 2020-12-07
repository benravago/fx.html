package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should import the given importedNode into that Document.
* The importedNode is of type Document_Fragment.
* 
* Create a DocumentFragment in a different document.
* Invoke method importNode(importedNode,deep) on this document
* with importedNode being the newly created DocumentFragment.
* Method should return an empty DocumentFragment that belongs
* to this document whose systemId is "staff.dtd" 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-systemId">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-systemId</a>
*/
@Disabled("2")
class Import_Node_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode08")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  DocumentFragment docFrag;
  Node aNode;
  boolean hasChild;
  Document ownerDocument;
  DocumentType docType;
  String system;
  doc = (Document) load("staffNS", true);
  aNewDoc = (Document) load("staffNS", true);
  docFrag = aNewDoc.createDocumentFragment();
  aNode = doc.importNode(docFrag, false);
  hasChild = aNode.hasChildNodes();
  assertFalse(hasChild, "hasChild");
  ownerDocument = aNode.getOwnerDocument();
  docType = ownerDocument.getDoctype();
  system = docType.getSystemId();
  assertTrue(equalsURI(null, null, null, "staffNS.dtd", null, null, null, null, system), "system");
 }
}