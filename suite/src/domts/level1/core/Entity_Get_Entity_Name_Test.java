package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The nodeName attribute that is inherited from Node  
* contains the name of the entity.
* 
* Retrieve the entity named "ent1" and access its name by 
* invoking the "getNodeName()" method inherited from
* the Node interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-527DCFF2">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-527DCFF2</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
*/
class Entity_Get_Entity_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/entitygetentityname")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entityList;
  Entity entityNode;
  String entityName;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  entityList = docType.getEntities();
  assertNotNull(entityList, "entitiesNotNull");
  entityNode = (Entity) entityList.getNamedItem("ent1");
  entityName = entityNode.getNodeName();
  assertEquals("ent1", entityName, "entityGetEntityNameAssert");
 }
}