package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "insertBefore(newChild,refChild)" method inserts the
* node "newChild" before the node "refChild". 
* 
* Insert a newly created Element node before the eigth
* child of the second employee and check the "newChild"
* and "refChild" after insertion for correct placement.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727</a>
*/
class Node_Insert_Before_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeinsertbefore")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node refChild;
  Node newChild;
  Node child;
  String childName;
  int length;
  Node insertedNode;
  List actual = new ArrayList();
  List expectedWithWhitespace = new ArrayList();
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("employeeId");
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("name");
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("position");
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("newChild");
  expectedWithWhitespace.add("salary");
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("gender");
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("address");
  expectedWithWhitespace.add("#text");
  List expectedWithoutWhitespace = new ArrayList();
  expectedWithoutWhitespace.add("employeeId");
  expectedWithoutWhitespace.add("name");
  expectedWithoutWhitespace.add("position");
  expectedWithoutWhitespace.add("newChild");
  expectedWithoutWhitespace.add("salary");
  expectedWithoutWhitespace.add("gender");
  expectedWithoutWhitespace.add("address");
  List expected = new ArrayList();
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  length = (int) childList.getLength();
  if (equals(6, length)) {
   refChild = childList.item(3);
   expected = expectedWithoutWhitespace;
  } else {
   refChild = childList.item(7);
   expected = expectedWithWhitespace;
  }
  newChild = doc.createElement("newChild");
  insertedNode = employeeNode.insertBefore(newChild, refChild);
  for (int indexN100DC = 0; indexN100DC < childList.getLength(); indexN100DC++) {
   child = (Node) childList.item(indexN100DC);
   childName = child.getNodeName();
   actual.add(childName);
  }
  assertEquals(expected, actual, "nodeNames");
 }
}