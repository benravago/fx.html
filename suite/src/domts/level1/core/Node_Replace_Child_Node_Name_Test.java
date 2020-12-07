package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Replace the second Element of the second employee with
* a newly created node Element and check the NodeName 
* returned by the "replaceChild(newChild,oldChild)"
* method.   The returned node should have a NodeName equal
* to "employeeId".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307</a>
*/
@Disabled("fx")
class Node_Replace_Child_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodereplacechildnodename")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node oldChild;
  Node newChild;
  Node replacedNode;
  int length;
  String childName;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  length = (int) childList.getLength();
  oldChild = childList.item(1);
  newChild = doc.createElement("newChild");
  replacedNode = employeeNode.replaceChild(newChild, oldChild);
  childName = replacedNode.getNodeName();
  if (equals(6, length)) {
   assertEquals("name", childName, "nowhitespace");
  } else {
   assertEquals("employeeId", childName, "whitespace");
  }
 }
}