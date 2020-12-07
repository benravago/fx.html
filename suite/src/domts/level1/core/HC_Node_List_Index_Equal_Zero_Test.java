package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Create a list of all the children elements of the third
* employee and access its first child by using an index
* of 0.  This should result in the whitspace before "em" being
* selected (em when ignoring whitespace).  
* Further we evaluate its content(by using
* the "getNodeName()" method) to ensure the proper
* element was accessed.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_List_Index_Equal_Zero_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodelistindexequalzero")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList employeeList;
  Node child;
  String childName;
  int length;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(2);
  employeeList = employeeNode.getChildNodes();
  length = (int) employeeList.getLength();
  child = employeeList.item(0);
  childName = child.getNodeName();
  if (equals(13, length)) {
   assertEquals("#text", childName, "childName_w_whitespace");
  } else {
   assertTrue(equalsAutoCase("element", "em", childName), "childName_wo_whitespace");
  }
 }
}