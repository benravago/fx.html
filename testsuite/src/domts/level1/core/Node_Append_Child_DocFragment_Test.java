package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Create and populate a new DocumentFragment object and
* append it to the second employee.   After the 
* "appendChild(newChild)" method is invoked retrieve the
* new nodes at the end of the list, they should be the
* two Element nodes from the DocumentFragment.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107</a>
*/
@Disabled("fx")
class Node_Append_Child_DocFragment_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeappendchilddocfragment")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  DocumentFragment newdocFragment;
  Node newChild1;
  Node newChild2;
  Node child;
  String childName;
  List result = new ArrayList();
  int nodeType;
  Node appendedChild;
  List expected = new ArrayList();
  expected.add("employeeId");
  expected.add("name");
  expected.add("position");
  expected.add("salary");
  expected.add("gender");
  expected.add("address");
  expected.add("newChild1");
  expected.add("newChild2");
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  newdocFragment = doc.createDocumentFragment();
  newChild1 = doc.createElement("newChild1");
  newChild2 = doc.createElement("newChild2");
  appendedChild = newdocFragment.appendChild(newChild1);
  appendedChild = newdocFragment.appendChild(newChild2);
  appendedChild = employeeNode.appendChild(newdocFragment);
  for (int indexN1009F = 0; indexN1009F < childList.getLength(); indexN1009F++) {
   child = (Node) childList.item(indexN1009F);
   nodeType = (int) child.getNodeType();
   if (equals(1, nodeType)) {
    childName = child.getNodeName();
    result.add(childName);
   }
  }
  assertEquals(expected, result, "elementNames");
 }
}