package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getFirstChild()" method returns the first child
* of this node. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-169727388">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-169727388</a>
*/
class Node_Get_First_Child_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodegetfirstchild")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  Node fchildNode;
  String childName;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  fchildNode = employeeNode.getFirstChild();
  childName = fchildNode.getNodeName();
  if (equals("#text", childName)) {
   fchildNode = fchildNode.getNextSibling();
   childName = fchildNode.getNodeName();
  }
  assertEquals("employeeId", childName, "nodeName");
 }
}