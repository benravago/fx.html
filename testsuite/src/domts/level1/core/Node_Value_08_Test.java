package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* An notation is accessed, setNodeValue is called with a non-null argument, but getNodeValue
* should still return null.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-5431D1B9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-5431D1B9</a>
*/
class Node_Value_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodevalue08")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  Node newNode;
  String newValue;
  NamedNodeMap nodeMap;
  doc = (Document) load("staff", true);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  nodeMap = docType.getNotations();
  assertNotNull(nodeMap, "notationsNotNull");
  newNode = nodeMap.getNamedItem("notation1");
  assertNotNull(newNode, "notationNotNull");
  newValue = newNode.getNodeValue();
  assertNull(newValue, "initiallyNull");
  newNode.setNodeValue("This should have no effect");
  newValue = newNode.getNodeValue();
  assertNull(newValue, "nullAfterAttemptedChange");
 }
}