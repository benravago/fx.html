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
* be set to "staff".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1060184317">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1060184317</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=251">http://www.w3.org/Bugs/Public/show_bug.cgi?id=251</a>
*/
class Node_Parent_Node_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeparentnode")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  Node parentNode;
  String parentName;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  parentNode = employeeNode.getParentNode();
  parentName = parentNode.getNodeName();
  if (("image/svg+xml".equals(getContentType()))) {
   assertEquals("svg", parentName, "svgTagName");
  } else {
   assertEquals("staff", parentName, "nodeParentNodeAssert1");
  }
 }
}