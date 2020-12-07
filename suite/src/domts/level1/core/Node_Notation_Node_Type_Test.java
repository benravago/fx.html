package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNodeType()" method for an Notation Node
* returns the constant value 12.
* Retrieve the Notation declaration in the DocumentType 
* node and invoke the "getNodeType()" method.   The method
* should return 12. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558</a>
*/
class Node_Notation_Node_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodenotationnodetype")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap notations;
  Notation notationNode;
  int nodeType;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  notations = docType.getNotations();
  assertNotNull(notations, "notationsNotNull");
  notationNode = (Notation) notations.getNamedItem("notation1");
  assertNotNull(notationNode, "notationNotNull");
  nodeType = (int) notationNode.getNodeType();
  assertEquals(12, nodeType, "nodeNotationNodeTypeAssert1");
 }
}