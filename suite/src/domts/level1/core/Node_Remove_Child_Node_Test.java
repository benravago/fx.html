package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the second employee and remove its first child.
* After the removal, the second employee should have five or twelve 
* children and the first child should now be the child
* that used to be at the second position in the list.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1734834066">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1734834066</a>
*/
class Node_Remove_Child_Node_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/noderemovechildnode")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node oldChild;
  Node child;
  String childName;
  int length;
  Node removedChild;
  String removedName;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  oldChild = childList.item(0);
  removedChild = employeeNode.removeChild(oldChild);
  removedName = removedChild.getNodeName();
  child = childList.item(0);
  childName = child.getNodeName();
  length = (int) childList.getLength();
  if (equals(5, length)) {
   assertEquals("employeeId", removedName, "removedNameNoWhitespace");
   assertEquals("name", childName, "childNameNoWhitespace");
  } else {
   assertEquals("#text", removedName, "removedName");
   assertEquals("employeeId", childName, "childName");
   assertEquals(12, length, "length");
  }
 }
}