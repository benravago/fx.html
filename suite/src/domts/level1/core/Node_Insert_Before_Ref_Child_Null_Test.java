package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the "refChild" is null then the
* "insertBefore(newChild,refChild)" method inserts the
* node "newChild" at the end of the list of children. 
* 
* Retrieve the second employee and invoke the
* "insertBefore(newChild,refChild)" method with
* refChild=null.   Since "refChild" is null the "newChild"
* should be added to the end of the list.   The last item
* in the list is checked after insertion.   The last Element
* node of the list should be "newChild".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727</a>
*/
class Node_Insert_Before_Ref_Child_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeinsertbeforerefchildnull")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node refChild = null;
  Node newChild;
  Node child;
  String childName;
  Node insertedNode;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  newChild = doc.createElement("newChild");
  insertedNode = employeeNode.insertBefore(newChild, refChild);
  child = employeeNode.getLastChild();
  childName = child.getNodeName();
  assertEquals("newChild", childName, "nodeInsertBeforeRefChildNullAssert1");
 }
}