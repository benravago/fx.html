package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNextSibling()" method returns the node immediately
* following this node. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6AC54C2F">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6AC54C2F</a>
*/
class Node_Get_Next_Sibling_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodegetnextsibling")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeIdNode;
  Node nsNode;
  String nsName;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employeeId");
  employeeIdNode = elementList.item(1);
  nsNode = employeeIdNode.getNextSibling();
  nsName = nsNode.getNodeName();
  if (equals("#text", nsName)) {
   nsNode = nsNode.getNextSibling();
   nsName = nsNode.getNodeName();
  }
  assertEquals("name", nsName, "nodeName");
 }
}