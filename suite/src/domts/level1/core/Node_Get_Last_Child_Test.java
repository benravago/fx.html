package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getLastChild()" method returns the last child
* of this node. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-61AD09FB">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-61AD09FB</a>
*/
class Node_Get_Last_Child_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodegetlastchild")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  Node lchildNode;
  String childName;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  lchildNode = employeeNode.getLastChild();
  childName = lchildNode.getNodeName();
  if (equals("#text", childName)) {
   lchildNode = lchildNode.getPreviousSibling();
   childName = lchildNode.getNodeName();
  }
  assertEquals("address", childName, "nodeName");
 }
}