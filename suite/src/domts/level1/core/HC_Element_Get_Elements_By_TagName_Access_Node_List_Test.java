package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagName(name)" method returns a list
* of all descendant Elements in the order the children
* were encountered in a pre order traversal of the element
* tree.
* Create a NodeList of all the descendant elements
* using the string "p" as the tagName.
* The method should return a NodeList whose length is
* "5" in the order the children were encountered.
* Access the FOURTH element in the NodeList.  The FOURTH
* element, the first or second should be an "em" node with
* the content "EMP0004".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Element_Get_Elements_By_TagName_Access_Node_List_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementgetelementsbytagnameaccessnodelist")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Node firstC;
  String childName;
  int nodeType;
  CharacterData employeeIDNode;
  String employeeID;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  testEmployee = (Element) elementList.item(3);
  firstC = testEmployee.getFirstChild();
  nodeType = (int) firstC.getNodeType();
  while (equals(3, nodeType)) {
   firstC = firstC.getNextSibling();
   nodeType = (int) firstC.getNodeType();
  }
  childName = firstC.getNodeName();
  assertTrue(equalsAutoCase("element", "em", childName), "childName");
  employeeIDNode = (CharacterData) firstC.getFirstChild();
  employeeID = employeeIDNode.getNodeValue();
  assertEquals("EMP0004", employeeID, "employeeID");
 }
}