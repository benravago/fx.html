package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the "newChild" is already in the tree, it is first
* removed before the new one is appended.
* 
* Retrieve the first child of the second employee and   
* append the first child to the end of the list.   After
* the "appendChild(newChild)" method is invoked the first 
* child should be the one that was second and the last
* child should be the one that was first.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107</a>
*/
class Node_Append_Child_Child_Exists_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeappendchildchildexists")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node childNode;
  Node newChild;
  Node lchild;
  Node fchild;
  String lchildName;
  String fchildName;
  Node appendedChild;
  String initialName;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  childNode = elementList.item(1);
  newChild = childNode.getFirstChild();
  initialName = newChild.getNodeName();
  appendedChild = childNode.appendChild(newChild);
  fchild = childNode.getFirstChild();
  fchildName = fchild.getNodeName();
  lchild = childNode.getLastChild();
  lchildName = lchild.getNodeName();
  if (equals("employeeId", initialName)) {
   assertEquals("name", fchildName, "assert1_nowhitespace");
   assertEquals("employeeId", lchildName, "assert2_nowhitespace");
  } else {
   assertEquals("employeeId", fchildName, "assert1");
   assertEquals("#text", lchildName, "assert2");
  }
 }
}