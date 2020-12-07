package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "replaceChild(newChild,oldChild)" method replaces 
* the node "oldChild" with the node "newChild". 
* 
* Replace the first element of the second employee with
* a newly created Element node.   Check the first position
* after the replacement operation is completed.   The new
* Element should be "newChild".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=247">http://www.w3.org/Bugs/Public/show_bug.cgi?id=247</a>
*/
class HC_Node_Replace_Child_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodereplacechild")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node oldChild;
  Node newChild;
  Node child;
  String childName;
  Node replacedNode;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  oldChild = childList.item(0);
  newChild = doc.createElement("br");
  replacedNode = employeeNode.replaceChild(newChild, oldChild);
  child = childList.item(0);
  childName = child.getNodeName();
  assertTrue(equalsAutoCase("element", "br", childName), "nodeName");
 }
}