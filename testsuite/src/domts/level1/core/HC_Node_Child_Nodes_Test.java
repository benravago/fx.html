package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* 
* The "getChildNodes()" method returns a NodeList
* that contains all children of this node. 
* 
* Retrieve the second employee and check the NodeList
* returned by the "getChildNodes()" method.   The
* length of the list should be 13.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_Child_Nodes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodechildnodes")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  Node childNode;
  NodeList childNodes;
  int nodeType;
  String childName;
  List actual = new ArrayList();
  List expected = new ArrayList();
  expected.add("em");
  expected.add("strong");
  expected.add("code");
  expected.add("sup");
  expected.add("var");
  expected.add("acronym");
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  childNodes = employeeNode.getChildNodes();
  for (int indexN1006C = 0; indexN1006C < childNodes.getLength(); indexN1006C++) {
   childNode = (Node) childNodes.item(indexN1006C);
   nodeType = (int) childNode.getNodeType();
   childName = childNode.getNodeName();
   if (equals(1, nodeType)) {
    actual.add(childName);
   } else {
    assertEquals(3, nodeType, "textNodeType");
   }
  }
  assertTrue(equalsAutoCase("element", expected, actual), "elementNames");
 }
}