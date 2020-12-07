package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should import the given importedNode into that Document.
* The importedNode is of type Notation.
* 
* Retrieve notation named "notation1" from document staffNS.xml.
* Invoke method importNode(importedNode,deep) where importedNode
* contains the retrieved notation and deep is false.  Method should
* return a node of type notation whose name is "notation1". 
* The returned node should belong to this document whose systemId is "staff.dtd"
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
@Disabled("2")
class Import_Node_13_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode13")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  DocumentType doc1Type;
  NamedNodeMap notationList;
  Notation notation;
  Notation aNode;
  Document ownerDocument;
  DocumentType docType;
  String system;
  String publicVal;
  doc = (Document) load("staffNS", true);
  aNewDoc = (Document) load("staffNS", true);
  doc1Type = aNewDoc.getDoctype();
  notationList = doc1Type.getNotations();
  assertNotNull(notationList, "notationsNotNull");
  notation = (Notation) notationList.getNamedItem("notation1");
  aNode = (Notation) doc.importNode(notation, false);
  ownerDocument = aNode.getOwnerDocument();
  docType = ownerDocument.getDoctype();
  system = docType.getSystemId();
  assertTrue(equalsURI(null, null, null, "staffNS.dtd", null, null, null, null, system), "systemId");
  publicVal = aNode.getPublicId();
  assertEquals("notation1File", publicVal, "publicId");
  system = aNode.getSystemId();
  assertNull(system, "notationSystemId");
 }
}