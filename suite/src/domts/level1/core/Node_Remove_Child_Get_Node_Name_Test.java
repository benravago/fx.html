package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Remove the first child of the second employee 
* and check the NodeName returned by the 
* "removeChild(oldChild)" method.   The returned node
* should have a NodeName equal to "#text" or employeeId depending on whitespace.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1734834066">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1734834066</a>
*/
class Node_Remove_Child_Get_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/noderemovechildgetnodename")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node oldChild;
  Node removedChild;
  String childName;
  int length;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  length = (int) childList.getLength();
  oldChild = childList.item(0);
  removedChild = employeeNode.removeChild(oldChild);
  childName = removedChild.getNodeName();
  if (equals(6, length)) {
   assertEquals("employeeId", childName, "nowhitespace");
  } else {
   assertEquals("#text", childName, "whitespace");
  }
 }
}