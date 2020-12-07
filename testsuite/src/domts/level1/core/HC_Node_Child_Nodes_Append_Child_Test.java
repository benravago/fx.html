package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The NodeList returned by the "getChildNodes()" method
* is live.   Changes on the node's children are immediately
* reflected on the nodes returned in the NodeList.
* 
* Create a NodeList of the children of the second employee
* and then add a newly created element that was created
* by the "createElement()" method(Document Interface) to
* the second employee by using the "appendChild()" method.
* The length of the NodeList should reflect this new
* addition to the child list.   It should return the value 14.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=247">http://www.w3.org/Bugs/Public/show_bug.cgi?id=247</a>
*/
class HC_Node_Child_Nodes_Append_Child_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodechildnodesappendchild")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node createdNode;
  Node childNode;
  String childName;
  int childType;
  Node textNode;
  List actual = new ArrayList();
  List expected = new ArrayList();
  expected.add("em");
  expected.add("strong");
  expected.add("code");
  expected.add("sup");
  expected.add("var");
  expected.add("acronym");
  expected.add("br");
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  createdNode = doc.createElement("br");
  employeeNode = employeeNode.appendChild(createdNode);
  for (int indexN10087 = 0; indexN10087 < childList.getLength(); indexN10087++) {
   childNode = (Node) childList.item(indexN10087);
   childName = childNode.getNodeName();
   childType = (int) childNode.getNodeType();
   if (equals(1, childType)) {
    actual.add(childName);
   } else {
    assertEquals(3, childType, "textNodeType");
   }
  }
  assertTrue(equalsAutoCase("element", expected, actual), "childElements");
 }
}