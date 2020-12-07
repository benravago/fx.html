package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Every node in the map returned by the "getEntities()"
* method implements the Entity interface.
* 
* Retrieve the Document Type for this document and create 
* a NamedNodeMap of all its entities.  Traverse the 
* entire list and examine the NodeType of each node
* in the list.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1788794630">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1788794630</a>
*/
class DocumentType_Get_Entities_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documenttypegetentitiestype")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entityList;
  Node entity;
  int entityType;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  entityList = docType.getEntities();
  assertNotNull(entityList, "entitiesNotNull");
  for (int indexN10049 = 0; indexN10049 < entityList.getLength(); indexN10049++) {
   entity = (Node) entityList.item(indexN10049);
   entityType = (int) entity.getNodeType();
   assertEquals(6, entityType, "documenttypeGetEntitiesTypeAssert");
  }
 }
}