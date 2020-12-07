package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getFirstChild()" method returns the first child
* of this node. 
* 
* Retrieve the second employee and invoke the
* "getFirstChild()" method.   The NodeName returned
* should be "#text" or "EM".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-169727388">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-169727388</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
class HC_Node_Get_First_Child_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodegetfirstchild")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  Node fchildNode;
  String childName;
  int nodeType;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  fchildNode = employeeNode.getFirstChild();
  childName = fchildNode.getNodeName();
  if (equals("#text", childName)) {
   assertEquals("#text", childName, "firstChild_w_whitespace");
  } else {
   assertTrue(equalsAutoCase("element", "em", childName), "firstChild_wo_whitespace");
  }
 }
}