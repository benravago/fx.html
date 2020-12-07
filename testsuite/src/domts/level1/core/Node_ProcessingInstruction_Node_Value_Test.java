package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeValue()" method for a 
* Processing Instruction Node is the content of the
* Processing Instruction(exclude the target).
* 
* Retrieve the Processing Instruction node in the XML file 
* and check the string returned by the "getNodeValue()" 
* method.   It should be equal to "PIDATA".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
*/
class Node_ProcessingInstruction_Node_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeprocessinginstructionnodevalue")
 void run() throws Throwable {
  Document doc;
  NodeList testList;
  Node piNode;
  String piValue;
  doc = (Document) load("staff", false);
  testList = doc.getChildNodes();
  piNode = testList.item(0);
  piValue = piNode.getNodeValue();
  assertEquals("PIDATA", piValue, "value");
 }
}