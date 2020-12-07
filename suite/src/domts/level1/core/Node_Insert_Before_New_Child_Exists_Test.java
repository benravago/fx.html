package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the "newChild" is already in the tree, the
* "insertBefore(newChild,refChild)" method must first
* remove it before the insertion takes place.
* 
* Insert a node Element ("employeeId") that is already
* present in the tree.   The existing node should be 
* removed first and the new one inserted.   The node is
* inserted at a different position in the tree to assure
* that it was indeed inserted.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727</a>
*/
class Node_Insert_Before_New_Child_Exists_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeinsertbeforenewchildexists")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node refChild;
  Node newChild;
  Node child;
  int length;
  String childName;
  Node insertedNode;
  List expectedWhitespace = new ArrayList();
  expectedWhitespace.add("#text");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("name");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("position");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("salary");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("gender");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("employeeId");
  expectedWhitespace.add("address");
  expectedWhitespace.add("#text");
  List expectedNoWhitespace = new ArrayList();
  expectedNoWhitespace.add("name");
  expectedNoWhitespace.add("position");
  expectedNoWhitespace.add("salary");
  expectedNoWhitespace.add("gender");
  expectedNoWhitespace.add("employeeId");
  expectedNoWhitespace.add("address");
  List expected = new ArrayList();
  List result = new ArrayList();
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  length = (int) childList.getLength();
  if (equals(6, length)) {
   expected = expectedNoWhitespace;
   refChild = childList.item(5);
   newChild = childList.item(0);
  } else {
   expected = expectedWhitespace;
   refChild = childList.item(11);
   newChild = childList.item(1);
  }
  insertedNode = employeeNode.insertBefore(newChild, refChild);
  for (int indexN100DD = 0; indexN100DD < childList.getLength(); indexN100DD++) {
   child = (Node) childList.item(indexN100DD);
   childName = child.getNodeName();
   result.add(childName);
  }
  assertEquals(expected, result, "childNames");
 }
}