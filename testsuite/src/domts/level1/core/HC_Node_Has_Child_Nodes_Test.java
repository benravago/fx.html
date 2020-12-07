package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "hasChildNodes()" method returns true if the node
* has children.
* 
* Retrieve the root node("staff") and invoke the 
* "hasChildNodes()" method.   It should return the boolean
* value "true".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-810594187">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-810594187</a>
*/
class HC_Node_Has_Child_Nodes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodehaschildnodes")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  boolean state;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  state = employeeNode.hasChildNodes();
  assertTrue(state, "nodeHasChildAssert1");
 }
}