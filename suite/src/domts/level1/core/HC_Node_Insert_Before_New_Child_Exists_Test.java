package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the "newChild" is already in the tree, the
* "insertBefore(newChild,refChild)" method must first
* remove it before the insertion takes place.
* 
* Insert a node Element ("em") that is already
* present in the tree.   The existing node should be 
* removed first and the new one inserted.   The node is
* inserted at a different position in the tree to assure
* that it was indeed inserted.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
@Disabled("fx")
class HC_Node_Insert_Before_New_Child_Exists_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeinsertbeforenewchildexists")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node refChild;
  Node newChild;
  Node child;
  String childName;
  Node insertedNode;
  List expected = new ArrayList();
  expected.add("strong");
  expected.add("code");
  expected.add("sup");
  expected.add("var");
  expected.add("em");
  expected.add("acronym");
  List result = new ArrayList();
  int nodeType;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  childList = ((Element) /*Node */employeeNode).getElementsByTagName("*");
  refChild = childList.item(5);
  newChild = childList.item(0);
  insertedNode = employeeNode.insertBefore(newChild, refChild);
  for (int indexN1008C = 0; indexN1008C < childList.getLength(); indexN1008C++) {
   child = (Node) childList.item(indexN1008C);
   nodeType = (int) child.getNodeType();
   if (equals(1, nodeType)) {
    childName = child.getNodeName();
    result.add(childName);
   }
  }
  assertTrue(equalsAutoCase("element", expected, result), "childNames");
 }
}