package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getPublicId()" method of an Entity node contains
* the public identifier associated with the entity, if
* one was not specified a null value should be returned.
* 
* Retrieve the entity named "ent1" and access its  
* public identifier.  Since a public identifier was not
* specified for this entity, the "getPublicId()" method 
* should return null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D7303025">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D7303025</a>
*/
class Entity_Get_PublicId_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/entitygetpublicidnull")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entityList;
  Entity entityNode;
  String publicId;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  entityList = docType.getEntities();
  assertNotNull(entityList, "entitiesNotNull");
  entityNode = (Entity) entityList.getNamedItem("ent1");
  publicId = entityNode.getPublicId();
  assertNull(publicId, "entityGetPublicIdNullAssert");
 }
}