package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If there is not a node immediately following this node the
* "getNextSibling()" method returns null.
* 
* Retrieve the first child of the second employee and
* invoke the "getNextSibling()" method.   It should
* be set to null. 
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6AC54C2F">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6AC54C2F</a>
*/
class HC_Node_Get_Next_Sibling_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodegetnextsiblingnull")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  Node lcNode;
  Node nsNode;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  lcNode = employeeNode.getLastChild();
  nsNode = lcNode.getNextSibling();
  assertNull(nsNode, "nodeGetNextSiblingNullAssert1");
 }
}