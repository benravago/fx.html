package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNodeType()" method for a Comment Node
* returns the constant value 8.
* 
* Retrieve the nodes from the document and check for
* a comment node and invoke the "getNodeType()" method.   This should   
* return 8. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1728279322">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1728279322</a>
*/
class Node_Comment_Node_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodecommentnodetype")
 void run() throws Throwable {
  Document doc;
  NodeList testList;
  Node commentNode;
  String commentNodeName;
  int nodeType;
  doc = (Document) load("staff", false);
  testList = doc.getChildNodes();
  for (int indexN10040 = 0; indexN10040 < testList.getLength(); indexN10040++) {
   commentNode = (Node) testList.item(indexN10040);
   commentNodeName = commentNode.getNodeName();
   if (equals("#comment", commentNodeName)) {
    nodeType = (int) commentNode.getNodeType();
    assertEquals(8, nodeType, "nodeCommentNodeTypeAssert1");
   }
  }
 }
}