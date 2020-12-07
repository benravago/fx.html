package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Create a list of all the children elements of the third
* employee and access its first child by invoking the 
* "item(index)" method with an index=0.  This should
* result in node with a nodeName of "#text" or "em".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_List_Return_First_Item_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodelistreturnfirstitem")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList employeeList;
  Node child;
  String childName;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(2);
  employeeList = employeeNode.getChildNodes();
  child = employeeList.item(0);
  childName = child.getNodeName();
  if (equals("#text", childName)) {
   assertEquals("#text", childName, "nodeName_w_space");
  } else {
   assertTrue(equalsAutoCase("element", "em", childName), "nodeName_wo_space");
  }
 }
}