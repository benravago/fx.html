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
* Retrieve the character data of the second "em" node and
* invoke the "getChildNodes()" method.   The
* NodeList returned should not have any nodes.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_Child_Nodes_Empty_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodechildnodesempty")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  NodeList childList;
  Node employeeNode;
  Node textNode;
  int length;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("em");
  employeeNode = elementList.item(1);
  textNode = employeeNode.getFirstChild();
  childList = textNode.getChildNodes();
  length = (int) childList.getLength();
  assertEquals(0, length, "length_zero");
 }
}