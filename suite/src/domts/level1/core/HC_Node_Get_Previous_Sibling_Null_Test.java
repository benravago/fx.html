package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If there is not a node immediately preceding this node the
* "getPreviousSibling()" method returns null.
* 
* Retrieve the first child of the second employee and
* invoke the "getPreviousSibling()" method.   It should
* be set to null. 
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-640FB3C8">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-640FB3C8</a>
*/
class HC_Node_Get_Previous_Sibling_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodegetprevioussiblingnull")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  Node fcNode;
  Node psNode;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(2);
  fcNode = employeeNode.getFirstChild();
  psNode = fcNode.getPreviousSibling();
  assertNull(psNode, "nodeGetPreviousSiblingNullAssert1");
 }
}