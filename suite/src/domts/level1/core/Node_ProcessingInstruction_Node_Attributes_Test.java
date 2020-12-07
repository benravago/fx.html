package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributes()" method invoked on a Processing 
* Instruction Node returns null.
* 
* Retrieve the Processing Instruction node and invoke 
* the "getAttributes()" method.   It should return null. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
*/
class Node_ProcessingInstruction_Node_Attributes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeprocessinginstructionnodeattributes")
 void run() throws Throwable {
  Document doc;
  NodeList testList;
  Node piNode;
  NamedNodeMap attrList;
  doc = (Document) load("staff", false);
  testList = doc.getChildNodes();
  piNode = testList.item(0);
  attrList = piNode.getAttributes();
  assertNull(attrList, "nodeProcessingInstructionNodeAttrAssert1");
 }
}