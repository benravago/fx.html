package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeValue()" method for an 
* Entity Node is always null and "setNodeValue" should have no effect.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-527DCFF2">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-527DCFF2</a>
*/
@Disabled("1")
class Node_Entity_Set_Node_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeentitysetnodevalue")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entities;
  Node entityNode;
  String entityValue;
  doc = (Document) load("staff", true);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  entities = docType.getEntities();
  assertNotNull(entities, "entitiesNotNull");
  entityNode = entities.getNamedItem("ent1");
  assertNotNull(entityNode, "ent1NotNull");
  entityNode.setNodeValue("This should have no effect");
  entityValue = entityNode.getNodeValue();
  assertNull(entityValue, "nodeValueNull");
 }
}