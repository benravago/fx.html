package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The range of valid child node indices is 0 thru length -1
* 
* Create a list of all the children elements of the third
* employee and traverse the list from index=0 thru
* length -1.     
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-203510337">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-203510337</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-844377136</a>
*/
class Node_List_Traverse_List_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodelisttraverselist")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList employeeList;
  Node child;
  String childName;
  List result = new ArrayList();
  int length;
  List expectedWhitespace = new ArrayList();
  expectedWhitespace.add("#text");
  expectedWhitespace.add("employeeId");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("name");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("position");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("salary");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("gender");
  expectedWhitespace.add("#text");
  expectedWhitespace.add("address");
  expectedWhitespace.add("#text");
  List expectedNoWhitespace = new ArrayList();
  expectedNoWhitespace.add("employeeId");
  expectedNoWhitespace.add("name");
  expectedNoWhitespace.add("position");
  expectedNoWhitespace.add("salary");
  expectedNoWhitespace.add("gender");
  expectedNoWhitespace.add("address");
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(2);
  employeeList = employeeNode.getChildNodes();
  length = (int) employeeList.getLength();
  for (int indexN100A4 = 0; indexN100A4 < employeeList.getLength(); indexN100A4++) {
   child = (Node) employeeList.item(indexN100A4);
   childName = child.getNodeName();
   result.add(childName);
  }
  if (equals(6, length)) {
   assertEquals(expectedNoWhitespace, result, "nowhitespace");
  } else {
   assertEquals(expectedWhitespace, result, "whitespace");
  }
 }
}