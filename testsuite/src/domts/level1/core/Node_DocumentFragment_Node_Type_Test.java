package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNodeType()" method for a DocumentFragment Node
* returns the constant value 11.
* Invoke the "createDocumentFragment()" method and    
* examine the NodeType of the document fragment
* returned by the "getNodeType()" method.   The method 
* should return 11. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A3">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A3</a>
*/
class Node_DocumentFragment_Node_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodedocumentfragmentnodetype")
 void run() throws Throwable {
  Document doc;
  DocumentFragment documentFragmentNode;
  int nodeType;
  doc = (Document) load("staff", true);
  documentFragmentNode = doc.createDocumentFragment();
  nodeType = (int) documentFragmentNode.getNodeType();
  assertEquals(11, nodeType, "nodeDocumentFragmentNodeTypeAssert1");
 }
}