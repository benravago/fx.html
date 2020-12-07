package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "insertBefore(newChild,refChild)" method inserts the
* node "newChild" before the node "refChild". 
* 
* Insert a newly created Element node before the second
* sup element in the document and check the "newChild"
* and "refChild" after insertion for correct placement.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=247">http://www.w3.org/Bugs/Public/show_bug.cgi?id=247</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=261">http://www.w3.org/Bugs/Public/show_bug.cgi?id=261</a>
*/
class HC_Node_Insert_Before_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeinsertbefore")
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
  List actual = new ArrayList();
  List expected = new ArrayList();
  expected.add("em");
  expected.add("strong");
  expected.add("code");
  expected.add("br");
  expected.add("sup");
  expected.add("var");
  expected.add("acronym");
  int nodeType;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("sup");
  refChild = elementList.item(2);
  employeeNode = refChild.getParentNode();
  childList = employeeNode.getChildNodes();
  newChild = doc.createElement("br");
  insertedNode = employeeNode.insertBefore(newChild, refChild);
  for (int indexN10091 = 0; indexN10091 < childList.getLength(); indexN10091++) {
   child = (Node) childList.item(indexN10091);
   nodeType = (int) child.getNodeType();
   if (equals(1, nodeType)) {
    childName = child.getNodeName();
    actual.add(childName);
   }
  }
  assertTrue(equalsAutoCase("element", expected, actual), "nodeNames");
 }
}