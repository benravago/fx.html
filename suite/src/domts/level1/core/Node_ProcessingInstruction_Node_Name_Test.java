package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeName()" method for a 
* Processing Instruction Node is the target.
* 
* Retrieve the Processing Instruction Node in the XML file 
* and check the string returned by the "getNodeName()" 
* method.   It should be equal to "XML-STYLE". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
*/
class Node_ProcessingInstruction_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeprocessinginstructionnodename")
 void run() throws Throwable {
  Document doc;
  NodeList testList;
  Node piNode;
  String piName;
  doc = (Document) load("staff", false);
  testList = doc.getChildNodes();
  piNode = testList.item(0);
  piName = piNode.getNodeName();
  assertEquals("TEST-STYLE", piName, "nodeProcessingInstructionNodeNameAssert1");
 }
}