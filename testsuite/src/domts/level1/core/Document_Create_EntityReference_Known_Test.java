package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createEntityReference(name)" method creates an 
* EntityReference node.  In addition, if the referenced entity
* is known, the child list of the "EntityReference" node
* is the same as the corresponding "Entity" node.
* 
* Retrieve the entire DOM document and invoke its 
* "createEntityReference(name)" method.  It should create 
* a new EntityReference node for the Entity with the 
* given name.  The referenced entity is known, therefore the child
* list of the "EntityReference" node is the same as the corresponding
* "Entity" node.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-392B75AE">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-392B75AE</a>
*/
@Disabled("1")
class Document_Create_EntityReference_Known_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentcreateentityreferenceknown")
 void run() throws Throwable {
  Document doc;
  EntityReference newEntRefNode;
  NodeList newEntRefList;
  Node child;
  String name;
  String value;
  doc = (Document) load("staff", true);
  newEntRefNode = doc.createEntityReference("ent3");
  assertNotNull(newEntRefNode, "createdEntRefNotNull");
  newEntRefList = newEntRefNode.getChildNodes();
  assertTrue(equalsSize(1, newEntRefList), "size");
  child = newEntRefNode.getFirstChild();
  name = child.getNodeName();
  assertEquals("#text", name, "name");
  value = child.getNodeValue();
  assertEquals("Texas", value, "value");
 }
}