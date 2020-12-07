package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "cloneNode(deep)" method returns a copy of the node
* and the subtree under it if deep=true.
* 
* Retrieve the second employee and invoke the
* "cloneNode(deep)" method with deep=true.   The
* method should clone this node and the subtree under it.
* The NodeName of each child in the returned node is 
* checked to insure the entire subtree under the second
* employee was cloned.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_Clone_Node_True_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeclonenodetrue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  Node clonedNode;
  NodeList clonedList;
  Node clonedChild;
  String clonedChildName;
  NodeList origList;
  Node origChild;
  String origChildName;
  List result = new ArrayList();
  List expected = new ArrayList();
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  origList = employeeNode.getChildNodes();
  for (int indexN10065 = 0; indexN10065 < origList.getLength(); indexN10065++) {
   origChild = (Node) origList.item(indexN10065);
   origChildName = origChild.getNodeName();
   expected.add(origChildName);
  }
  clonedNode = employeeNode.cloneNode(true);
  clonedList = clonedNode.getChildNodes();
  for (int indexN1007B = 0; indexN1007B < clonedList.getLength(); indexN1007B++) {
   clonedChild = (Node) clonedList.item(indexN1007B);
   clonedChildName = clonedChild.getNodeName();
   result.add(clonedChildName);
  }
  assertEquals(expected, result, "clone");
 }
}