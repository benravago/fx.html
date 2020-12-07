package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should import the given importedNode into that Document.
* The importedNode is of type Entity_Reference.
* Only the EntityReference is copied, regardless of deep's value.
* If the Document provides a definition for the entity name, its value is assigned.
* 
* Create an entity reference whose name is "ent3" in a different document.
* Invoke method importNode(importedNode,deep) on this document with importedNode
* being "ent3".
* Method should return a node of type Entity_Reference whose first child's value is "Texas" as defined
* in this document.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
@Disabled("2")
class Import_Node_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode11")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  EntityReference entRef;
  Node aNode;
  String name;
  Node child;
  String childValue;
  doc = (Document) load("staff", true);
  aNewDoc = (Document) load("staff", true);
  entRef = aNewDoc.createEntityReference("ent3");
  assertNotNull(entRef, "createdEntRefNotNull");
  aNode = doc.importNode(entRef, true);
  name = aNode.getNodeName();
  assertEquals("ent3", name, "entityName");
  child = aNode.getFirstChild();
  assertNotNull(child, "child");
  childValue = child.getNodeValue();
  assertEquals("Texas", childValue, "childValue");
 }
}