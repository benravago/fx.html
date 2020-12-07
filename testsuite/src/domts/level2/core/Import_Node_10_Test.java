package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should import the given importedNode into that Document.
* The importedNode is of type Entity_Reference.
* Only the EntityReference is copied, regardless of deep's value.
* 
* Create an entity reference whose name is "entRef1" in a different document.
* Give it value "entRef1Value".
* Invoke method importNode(importedNode,deep) on this document with importedNode
* being "entRef1".
* Method should return a node of type Entity_Reference (whose value is null) that
* belongs to this document whose systemId is "staff.dtd".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
@Disabled("2")
class Import_Node_10_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode10")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  EntityReference entRef;
  Node aNode;
  Document ownerDocument;
  DocumentType docType;
  String system;
  String name;
  doc = (Document) load("staffNS", true);
  aNewDoc = (Document) load("staffNS", true);
  entRef = aNewDoc.createEntityReference("entRef1");
  assertNotNull(entRef, "createdEntRefNotNull");
  entRef.setNodeValue("entRef1Value");
  aNode = doc.importNode(entRef, false);
  ownerDocument = aNode.getOwnerDocument();
  docType = ownerDocument.getDoctype();
  system = docType.getSystemId();
  assertTrue(equalsURI(null, null, null, "staffNS.dtd", null, null, null, null, system), "systemId");
  name = aNode.getNodeName();
  assertEquals("entRef1", name, "nodeName");
 }
}