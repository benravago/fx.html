package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Setting the nodeValue should change the value returned by
* nodeValue and ProcessingInstruction.getData.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1004215813">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1004215813</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-837822393">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-837822393</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=181">http://www.w3.org/Bugs/Public/show_bug.cgi?id=181</a>
*/
class Node_ProcessingInstruction_Set_Node_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeprocessinginstructionsetnodevalue")
 void run() throws Throwable {
  Document doc;
  NodeList testList;
  Node piNode;
  String piValue;
  doc = (Document) load("staff", true);
  testList = doc.getChildNodes();
  piNode = testList.item(0);
  piNode.setNodeValue("Something different");
  piValue = piNode.getNodeValue();
  assertEquals("Something different", piValue, "nodeValue");
  piValue = ((ProcessingInstruction) /*Node */piNode).getData();
  assertEquals("Something different", piValue, "data");
 }
}