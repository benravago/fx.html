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
* Using the method importNode with deep=true/false, import a entity nodes ent2 and ent6
* from this document to a new document object.  Verify if the nodes have been 
* imported correctly by checking the nodeNames of the imported nodes and public and system ids.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Document_Import_Node_19_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode19")
 void run() throws Throwable {
  Document doc;
  DocumentType docTypeNull = null;
  Document docImp;
  DOMImplementation domImpl;
  DocumentType docType;
  NamedNodeMap nodeMap;
  Entity entity2;
  Entity entity6;
  Entity entityImp2;
  Entity entityImp6;
  String nodeName;
  String systemId;
  String notationName;
  String nodeNameImp;
  String systemIdImp;
  String notationNameImp;
  doc = (Document) load("staffNS", true);
  domImpl = doc.getImplementation();
  docType = doc.getDoctype();
  docImp = domImpl.createDocument("http://www.w3.org/DOM/Test", "a:b", docTypeNull);
  nodeMap = docType.getEntities();
  assertNotNull(nodeMap, "entitiesNotNull");
  entity2 = (Entity) nodeMap.getNamedItem("ent2");
  entity6 = (Entity) nodeMap.getNamedItem("ent6");
  entityImp2 = (Entity) docImp.importNode(entity2, false);
  entityImp6 = (Entity) docImp.importNode(entity6, true);
  nodeName = entity2.getNodeName();
  nodeNameImp = entityImp2.getNodeName();
  assertEquals(nodeName, nodeNameImp, "documentimportnode19_Ent2NodeName");
  nodeName = entity6.getNodeName();
  nodeNameImp = entityImp6.getNodeName();
  assertEquals(nodeName, nodeNameImp, "documentimportnode19_Ent6NodeName");
  systemId = entity2.getSystemId();
  systemIdImp = entityImp2.getSystemId();
  assertEquals(systemId, systemIdImp, "documentimportnode19_Ent2SystemId");
  systemId = entity6.getSystemId();
  systemIdImp = entityImp6.getSystemId();
  assertEquals(systemId, systemIdImp, "documentimportnode19_Ent6SystemId");
  notationName = entity2.getNotationName();
  notationNameImp = entityImp2.getNotationName();
  assertEquals(notationName, notationNameImp, "documentimportnode19_Ent2NotationName");
  notationName = entity6.getNotationName();
  notationNameImp = entityImp6.getNotationName();
  assertEquals(notationName, notationNameImp, "documentimportnode19_Ent6NotationName");
 }
}