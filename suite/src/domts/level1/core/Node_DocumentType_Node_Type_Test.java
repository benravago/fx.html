package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNodeType()" method for a DocumentType Node
* returns the constant value 10.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558</a>
*/
class Node_DocumentType_Node_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodedocumenttypenodetype")
 void run() throws Throwable {
  Document doc;
  DocumentType documentTypeNode;
  int nodeType;
  doc = (Document) load("staff", false);
  documentTypeNode = doc.getDoctype();
  assertNotNull(documentTypeNode, "doctypeNotNull");
  nodeType = (int) documentTypeNode.getNodeType();
  assertEquals(10, nodeType, "nodeType");
 }
}