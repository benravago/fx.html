package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getParentNode()" method returns the parent
* of this node. 
* 
* Retrieve the second employee and invoke the 
* "getParentNode()" method on this node.   It should
* be set to "body".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1060184317">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1060184317</a>
*/
class HC_Node_Parent_Node_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeparentnode")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  Node parentNode;
  String parentName;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  parentNode = employeeNode.getParentNode();
  parentName = parentNode.getNodeName();
  assertTrue(equalsAutoCase("element", "body", parentName), "parentNodeName");
 }
}