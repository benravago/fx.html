package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "cloneNode(deep)" method returns a copy of the node
* and the subtree under it if deep=true.
* 
* Retrieve the second employee and invoke the
* "cloneNode(deep)" method with deep=true.   The
* method should clone this node and the subtree under it.
* The NodeName of each child in the returned node is 
* checked to insure the entire subtree under the second
* employee was cloned.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4</a>
*/
@Disabled("fx")
class Node_Clone_Node_True_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeclonenodetrue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node clonedNode;
  NodeList clonedList;
  Node clonedChild;
  String clonedChildName;
  int length;
  List result = new ArrayList();
  List expectedWhitespace = new ArrayList();
  expectedWhitespace.add("#text");
  expectedWhitespace.add("employeeId");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("name");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("position");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("salary");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("gender");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("address");
  expectedWhitespace.add("#text");
  List expectedNoWhitespace = new ArrayList();
  expectedNoWhitespace.add("employeeId");
  expectedNoWhitespace.add("name");
  expectedNoWhitespace.add("position");
  expectedNoWhitespace.add("salary");
  expectedNoWhitespace.add("gender");
  expectedNoWhitespace.add("address");
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  length = (int) childList.getLength();
  clonedNode = employeeNode.cloneNode(true);
  clonedList = clonedNode.getChildNodes();
  for (int indexN100AE = 0; indexN100AE < clonedList.getLength(); indexN100AE++) {
   clonedChild = (Node) clonedList.item(indexN100AE);
   clonedChildName = clonedChild.getNodeName();
   result.add(clonedChildName);
  }
  if (equals(6, length)) {
   assertEquals(expectedNoWhitespace, result, "nowhitespace");
  } else {
   assertEquals(expectedWhitespace, result, "whitespace");
  }
 }
}