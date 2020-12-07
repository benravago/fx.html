package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeValue()" method for a 
* Notation Node is null.
* Retrieve the Notation declaration inside the 
* DocumentType node and check the string returned 
* by the "getNodeValue()" method.   It should be equal to 
* null. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
*/
class Node_Notation_Node_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodenotationnodevalue")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap notations;
  Node notationNode;
  String notationValue;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  notations = docType.getNotations();
  assertNotNull(notations, "notationsNotNull");
  notationNode = notations.getNamedItem("notation1");
  assertNotNull(notationNode, "notationNotNull");
  notationValue = notationNode.getNodeValue();
  assertNull(notationValue, "nodeValue");
 }
}