package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Create a list of all the children elements of the third
* employee and access its last child by invoking the 
* "item(index)" method with an index=length-1.  This should
* result in node with nodeName="#text" or acronym.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_List_Return_Last_Item_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodelistreturnlastitem")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList employeeList;
  Node child;
  String childName;
  int index;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(2);
  employeeList = employeeNode.getChildNodes();
  index = (int) employeeList.getLength();
  index -= 1;
  child = employeeList.item(((int) /*int */index));
  childName = child.getNodeName();
  if (equals(12, index)) {
   assertEquals("#text", childName, "lastNodeName_w_whitespace");
  } else {
   assertTrue(equalsAutoCase("element", "acronym", childName), "lastNodeName");
   assertEquals(5, index, "index");
  }
 }
}