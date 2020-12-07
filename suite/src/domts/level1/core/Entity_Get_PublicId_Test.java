package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getPublicId()" method of an Entity node contains
* the public identifier associated with the entity, if
* one was specified.
* 
* Retrieve the entity named "ent5" and access its  
* public identifier.  The string "entityURI" should be
* returned.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D7303025">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D7303025</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6ABAEB38">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6ABAEB38</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D7C29F3E">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D7C29F3E</a>
*/
@Disabled("1")
class Entity_Get_PublicId_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/entitygetpublicid")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entityList;
  Entity entityNode;
  String publicId;
  String systemId;
  String notation;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  entityList = docType.getEntities();
  assertNotNull(entityList, "entitiesNotNull");
  entityNode = (Entity) entityList.getNamedItem("ent5");
  publicId = entityNode.getPublicId();
  assertEquals("entityURI", publicId, "publicId");
  systemId = entityNode.getSystemId();
  assertTrue(equalsURI(null, null, null, "entityFile", null, null, null, null, systemId), "systemId");
  notation = entityNode.getNotationName();
  assertEquals("notation1", notation, "notation");
 }
}