package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributes()" method invoked on an Entity 
* Node returns null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
*/
class Node_Entity_Node_Attributes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeentitynodeattributes")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entities;
  Node entityNode;
  NamedNodeMap attrList;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  entities = docType.getEntities();
  assertNotNull(entities, "entitiesNotNull");
  entityNode = entities.getNamedItem("ent1");
  assertNotNull(entityNode, "ent1NotNull");
  attrList = entityNode.getAttributes();
  assertNull(attrList, "entityAttributesNull");
 }
}