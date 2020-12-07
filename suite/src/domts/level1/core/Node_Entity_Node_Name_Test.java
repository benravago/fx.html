package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Check the nodeName of the entity returned by DocumentType.entities.getNamedItem("ent1").
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
*/
class Node_Entity_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeentitynodename")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entities;
  Node entityNode;
  String entityName;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  entities = docType.getEntities();
  assertNotNull(entities, "entitiesNotNull");
  entityNode = entities.getNamedItem("ent1");
  assertNotNull(entityNode, "entityNodeNotNull");
  entityName = entityNode.getNodeName();
  assertEquals("ent1", entityName, "entityNodeName");
 }
}