package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should import the given importedNode into that Document.
* The importedNode is of type Entity.
* 
* Retrieve entity "ent4" from staffNS.xml document.  
* Invoke method importNode(importedNode,deep) on this document with deep as false.
* Method should return a node of type Entity whose descendant is copied.
* The returned node should belong to this document whose systemId is "staffNS.dtd"
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
@Disabled("2")
class Import_Node_12_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode12")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  DocumentType doc1Type;
  NamedNodeMap entityList;
  Entity entity2;
  Entity entity1;
  Document ownerDocument;
  DocumentType docType;
  String system;
  String entityName;
  Node child;
  String childName;
  doc = (Document) load("staffNS", true);
  aNewDoc = (Document) load("staffNS", true);
  doc1Type = aNewDoc.getDoctype();
  entityList = doc1Type.getEntities();
  assertNotNull(entityList, "entitiesNotNull");
  entity2 = (Entity) entityList.getNamedItem("ent4");
  entity1 = (Entity) doc.importNode(entity2, true);
  ownerDocument = entity1.getOwnerDocument();
  docType = ownerDocument.getDoctype();
  system = docType.getSystemId();
  assertTrue(equalsURI(null, null, null, "staffNS.dtd", null, null, null, null, system), "systemId");
  entityName = entity1.getNodeName();
  assertEquals("ent4", entityName, "entityName");
  child = entity1.getFirstChild();
  assertNotNull(child, "notnull");
  childName = child.getNodeName();
  assertEquals("entElement1", childName, "childName");
 }
}