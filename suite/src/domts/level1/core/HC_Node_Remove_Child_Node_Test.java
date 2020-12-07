package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeChild(oldChild)" method removes the node
* indicated by "oldChild". 
* 
* Retrieve the second p element and remove its first child.
* After the removal, the second p element should have 5 element
* children and the first child should now be the child
* that used to be at the second position in the list.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1734834066">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1734834066</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_Remove_Child_Node_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_noderemovechildnode")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  NodeList emList;
  Node employeeNode;
  NodeList childList;
  Node oldChild;
  Node child;
  String childName;
  int length;
  Node removedChild;
  String removedName;
  int nodeType;
  List expected = new ArrayList();
  expected.add("strong");
  expected.add("code");
  expected.add("sup");
  expected.add("var");
  expected.add("acronym");
  List actual = new ArrayList();
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  emList = ((Element) /*Node */employeeNode).getElementsByTagName("em");
  oldChild = emList.item(0);
  removedChild = employeeNode.removeChild(oldChild);
  removedName = removedChild.getNodeName();
  assertTrue(equalsAutoCase("element", "em", removedName), "removedName");
  for (int indexN10098 = 0; indexN10098 < childList.getLength(); indexN10098++) {
   child = (Node) childList.item(indexN10098);
   nodeType = (int) child.getNodeType();
   childName = child.getNodeName();
   if (equals(1, nodeType)) {
    actual.add(childName);
   } else {
    assertEquals(3, nodeType, "textNodeType");
    assertEquals("#text", childName, "textNodeName");
   }
  }
  assertTrue(equalsAutoCase("element", expected, actual), "childNames");
 }
}