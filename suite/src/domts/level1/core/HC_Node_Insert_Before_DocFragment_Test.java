package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the "newChild" is a DocumentFragment object then all
* its children are inserted in the same order before the
* the "refChild". 
* 
* Create a DocumentFragment object and populate it with
* two Element nodes.   Retrieve the second employee and
* insert the newly created DocumentFragment before its
* fourth child.   The second employee should now have two
* extra children("newChild1" and "newChild2") at 
* positions fourth and fifth respectively.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=247">http://www.w3.org/Bugs/Public/show_bug.cgi?id=247</a>
*/
@Disabled("fx")
class HC_Node_Insert_Before_DocFragment_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeinsertbeforedocfragment")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node refChild;
  DocumentFragment newdocFragment;
  Node newChild1;
  Node newChild2;
  Node child;
  String childName;
  Node appendedChild;
  Node insertedNode;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  refChild = childList.item(3);
  newdocFragment = doc.createDocumentFragment();
  newChild1 = doc.createElement("br");
  newChild2 = doc.createElement("b");
  appendedChild = newdocFragment.appendChild(newChild1);
  appendedChild = newdocFragment.appendChild(newChild2);
  insertedNode = employeeNode.insertBefore(newdocFragment, refChild);
  child = childList.item(3);
  childName = child.getNodeName();
  assertTrue(equalsAutoCase("element", "br", childName), "childName3");
  child = childList.item(4);
  childName = child.getNodeName();
  assertTrue(equalsAutoCase("element", "b", childName), "childName4");
 }
}