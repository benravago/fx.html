package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the "newChild" is a DocumentFragment object then
* all its content is added to the child list of this node.
* 
* Create and populate a new DocumentFragment object and
* append it to the second employee.   After the 
* "appendChild(newChild)" method is invoked retrieve the
* new nodes at the end of the list, they should be the
* two Element nodes from the DocumentFragment.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=247">http://www.w3.org/Bugs/Public/show_bug.cgi?id=247</a>
*/
@Disabled("fx")
class HC_Node_Append_Child_DocFragment_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeappendchilddocfragment")
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
  Node appendedChild;
  int nodeType;
  List expected = new ArrayList();
  expected.add("em");
  expected.add("strong");
  expected.add("code");
  expected.add("sup");
  expected.add("var");
  expected.add("acronym");
  expected.add("br");
  expected.add("b");
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  newdocFragment = doc.createDocumentFragment();
  newChild1 = doc.createElement("br");
  newChild2 = doc.createElement("b");
  appendedChild = newdocFragment.appendChild(newChild1);
  appendedChild = newdocFragment.appendChild(newChild2);
  appendedChild = employeeNode.appendChild(newdocFragment);
  for (int indexN100A2 = 0; indexN100A2 < childList.getLength(); indexN100A2++) {
   child = (Node) childList.item(indexN100A2);
   nodeType = (int) child.getNodeType();
   if (equals(1, nodeType)) {
    childName = child.getNodeName();
    result.add(childName);
   }
  }
  assertTrue(equalsAutoCase("element", expected, result), "nodeNames");
 }
}