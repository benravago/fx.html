package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getChildNodes()" method returns a NodeList
* that contains all children of this node.   If there
* are not any children, this is a NodeList that does not 
* contain any nodes. 
* Retrieve the Text node from the second child of the second
* employee and invoke the "getChildNodes()" method.   The
* NodeList returned should not have any nodes.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987</a>
*/
class Node_Child_Nodes_Empty_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodechildnodesempty")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node secondCNode;
  Node textNode;
  NodeList childNodesList;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  secondCNode = childList.item(1);
  textNode = secondCNode.getFirstChild();
  childNodesList = textNode.getChildNodes();
  assertTrue(equalsSize(0, childNodesList), "nodeChildNodesEmptyAssert1");
 }
}