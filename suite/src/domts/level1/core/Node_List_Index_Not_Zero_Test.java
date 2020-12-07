package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Create a list of all the children elements of the third
* employee and access its fourth child by using an index
* of 3.  This should result in "name" being
* selected.  Further we evaluate its content(by using
* the "getNodeName()" method) to ensure the proper
* element was accessed.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136</a>
*/
class Node_List_Index_Not_Zero_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodelistindexnotzero")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList employeeList;
  Node child;
  int length;
  String childName;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(2);
  employeeList = employeeNode.getChildNodes();
  length = (int) employeeList.getLength();
  if (equals(6, length)) {
   child = employeeList.item(1);
  } else {
   child = employeeList.item(3);
  }
  childName = child.getNodeName();
  assertEquals("name", childName, "nodeName");
 }
}