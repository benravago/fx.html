package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "cloneNode(deep)" method does not copy text unless it
* is deep cloned.(Test for deep=false)
* 
* Retrieve the fourth child of the second employee and
* the "cloneNode(deep)" method with deep=false.   The
* duplicate node returned by the method should not copy
* any text data contained in this node.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4</a>
*/
class Node_Clone_False_No_Copy_Text_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeclonefalsenocopytext")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node childNode;
  Node clonedNode;
  Node lastChildNode;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  childNode = childList.item(3);
  clonedNode = childNode.cloneNode(false);
  lastChildNode = clonedNode.getLastChild();
  assertNull(lastChildNode, "noTextNodes");
 }
}