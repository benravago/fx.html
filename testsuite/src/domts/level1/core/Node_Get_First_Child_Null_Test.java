package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If there is not a first child then the "getFirstChild()"
* method returns null.
* 
* Retrieve the Text node form the second child of the first
* employee and invoke the "getFirstChild()" method.   It
* should return null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-169727388">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-169727388</a>
*/
class Node_Get_First_Child_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodegetfirstchildnull")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList employeeList;
  Node secondChildNode;
  Node textNode;
  Node noChildNode;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(0);
  employeeList = employeeNode.getChildNodes();
  secondChildNode = employeeList.item(1);
  textNode = secondChildNode.getFirstChild();
  noChildNode = textNode.getFirstChild();
  assertNull(noChildNode, "nodeGetFirstChildNullAssert1");
 }
}