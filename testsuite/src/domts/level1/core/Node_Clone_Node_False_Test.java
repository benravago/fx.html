package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "cloneNode(deep)" method returns a copy of the node
* only if deep=false.
* 
* Retrieve the second employee and invoke the
* "cloneNode(deep)" method with deep=false.   The
* method should only clone this node.   The NodeName and
* length of the NodeList are checked.   The "getNodeName()"
* method should return "employee" and the "getLength()"
* method should return 0.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4</a>
*/
class Node_Clone_Node_False_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeclonenodefalse")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  Node clonedNode;
  String cloneName;
  NodeList cloneChildren;
  int length;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  clonedNode = employeeNode.cloneNode(false);
  cloneName = clonedNode.getNodeName();
  assertEquals("employee", cloneName, "name");
  cloneChildren = clonedNode.getChildNodes();
  length = (int) cloneChildren.getLength();
  assertEquals(0, length, "length");
 }
}