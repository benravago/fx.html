package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Get the first child of the third employee using NodeList.item(0)
* which will either be a Text node (whitespace) or employeeId element.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136</a>
*/
class Node_List_Return_First_Item_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodelistreturnfirstitem")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList employeeList;
  Node child;
  String childName;
  int length;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(2);
  employeeList = employeeNode.getChildNodes();
  child = employeeList.item(0);
  childName = child.getNodeName();
  length = (int) employeeList.getLength();
  if (equals(6, length)) {
   assertTrue(equalsIgnoreCase("employeeId", childName), "firstChildNoWhitespace");
  } else {
   assertTrue(equalsIgnoreCase("#text", childName), "firstChildWithWhitespace");
  }
 }
}