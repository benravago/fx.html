package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createEntityReference(name)" method creates an 
* EntityReferrence node.
* 
* Retrieve the entire DOM document and invoke its 
* "createEntityReference(name)" method.  It should create 
* a new EntityReference node for the Entity with the 
* given name.  The name, value and type are retrieved and
* output.
* @author NIST
* @author Mary Brady
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-392B75AE">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-392B75AE</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
*/
class Document_Create_EntityReference_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentcreateentityreference")
 void run() throws Throwable {
  Document doc;
  EntityReference newEntRefNode;
  String entRefValue;
  String entRefName;
  int entRefType;
  doc = (Document) load("staff", true);
  newEntRefNode = doc.createEntityReference("ent1");
  assertNotNull(newEntRefNode, "createdEntRefNotNull");
  entRefValue = newEntRefNode.getNodeValue();
  assertNull(entRefValue, "value");
  entRefName = newEntRefNode.getNodeName();
  assertEquals("ent1", entRefName, "name");
  entRefType = (int) newEntRefNode.getNodeType();
  assertEquals(5, entRefType, "type");
 }
}