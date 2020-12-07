package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "replaceChild(newChild,oldChild)" method returns 
* the node being replaced.
* 
* Replace the second Element of the second employee with
* a newly created node Element and check the NodeName 
* returned by the "replaceChild(newChild,oldChild)"
* method.   The returned node should have a NodeName equal
* to "em".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=247">http://www.w3.org/Bugs/Public/show_bug.cgi?id=247</a>
*/
@Disabled("fx")
class HC_Node_Replace_Child_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodereplacechildnodename")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node oldChild;
  Node newChild;
  Node replacedNode;
  String childName;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  childList = ((Element) /*Node */employeeNode).getElementsByTagName("em");
  oldChild = childList.item(0);
  newChild = doc.createElement("br");
  replacedNode = employeeNode.replaceChild(newChild, oldChild);
  childName = replacedNode.getNodeName();
  assertTrue(equalsAutoCase("element", "em", childName), "replacedNodeName");
 }
}