package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* An Entity is accessed, setNodeValue is called with a non-null argument, but getNodeValue
* should still return null.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-527DCFF2">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-527DCFF2</a>
*/
@Disabled("1")
class Node_Value_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodevalue07")
 void run() throws Throwable {
  Document doc;
  Node newNode;
  String newValue;
  NamedNodeMap nodeMap;
  DocumentType docType;
  doc = (Document) load("staff", true);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  nodeMap = docType.getEntities();
  assertNotNull(nodeMap, "entitiesNotNull");
  newNode = nodeMap.getNamedItem("ent1");
  assertNotNull(newNode, "entityNotNull");
  newValue = newNode.getNodeValue();
  assertNull(newValue, "initiallyNull");
  newNode.setNodeValue("This should have no effect");
  newValue = newNode.getNodeValue();
  assertNull(newValue, "nullAfterAttemptedChange");
 }
}