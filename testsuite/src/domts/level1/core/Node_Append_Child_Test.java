package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "appendChild(newChild)" method adds the node
* "newChild" to the end of the list of children of the
* node.
* 
* Retrieve the second employee and append a new Element
* node to the list of children.   The last node in the list
* is then retrieved and its NodeName examined.   The
* "getNodeName()" method should return "newChild".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107</a>
*/
class Node_Append_Child_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeappendchild")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node createdNode;
  Node lchild;
  String childName;
  Node appendedChild;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  createdNode = doc.createElement("newChild");
  appendedChild = employeeNode.appendChild(createdNode);
  lchild = employeeNode.getLastChild();
  childName = lchild.getNodeName();
  assertEquals("newChild", childName, "nodeAppendChildAssert1");
 }
}