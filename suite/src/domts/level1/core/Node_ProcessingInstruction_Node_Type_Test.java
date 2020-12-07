package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNodeType()" method for a Processing Instruction 
* node returns the constant value 7.
* 
* Retrieve a NodeList of child elements from the document.
* Retrieve the first child and invoke the "getNodeType()"   
* method.   The method should return 7. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558</a>
*/
class Node_ProcessingInstruction_Node_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeprocessinginstructionnodetype")
 void run() throws Throwable {
  Document doc;
  NodeList testList;
  Node piNode;
  int nodeType;
  doc = (Document) load("staff", false);
  testList = doc.getChildNodes();
  piNode = testList.item(0);
  nodeType = (int) piNode.getNodeType();
  assertEquals(7, nodeType, "nodeProcessingInstructionNodeTypeAssert1");
 }
}