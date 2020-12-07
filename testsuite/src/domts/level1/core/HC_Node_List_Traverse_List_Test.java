package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The range of valid child node indices is 0 thru length -1
* 
* Create a list of all the children elements of the third
* employee and traverse the list from index=0 thru
* length -1.     
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-203510337">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-203510337</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_List_Traverse_List_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodelisttraverselist")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList employeeList;
  Node child;
  String childName;
  int nodeType;
  List result = new ArrayList();
  List expected = new ArrayList();
  expected.add("em");
  expected.add("strong");
  expected.add("code");
  expected.add("sup");
  expected.add("var");
  expected.add("acronym");
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(2);
  employeeList = employeeNode.getChildNodes();
  for (int indexN10073 = 0; indexN10073 < employeeList.getLength(); indexN10073++) {
   child = (Node) employeeList.item(indexN10073);
   nodeType = (int) child.getNodeType();
   childName = child.getNodeName();
   if (equals(1, nodeType)) {
    result.add(childName);
   } else {
    assertEquals(3, nodeType, "textNodeType");
    assertEquals("#text", childName, "textNodeName");
   }
  }
  assertTrue(equalsAutoCase("element", expected, result), "nodeNames");
 }
}