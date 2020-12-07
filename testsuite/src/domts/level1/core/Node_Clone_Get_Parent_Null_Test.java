package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The duplicate node returned by the "cloneNode(deep)"
* method does not have a ParentNode.
* 
* Retrieve the second employee and invoke the
* "cloneNode(deep)" method with deep=false.   The
* duplicate node returned should return null when the
* "getParentNode()" is invoked.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4</a>
*/
class Node_Clone_Get_Parent_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeclonegetparentnull")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  Node clonedNode;
  Node parentNode;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  clonedNode = employeeNode.cloneNode(false);
  parentNode = clonedNode.getParentNode();
  assertNull(parentNode, "nodeCloneGetParentNullAssert1");
 }
}