package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Collect the element names from Node.childNodes and check against expectations.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987</a>
*/
class Node_Child_Nodes_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodechildnodes")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childNodes;
  Node childNode;
  int childType;
  String childName;
  List elementNames = new ArrayList();
  List expectedElementNames = new ArrayList();
  expectedElementNames.add("employeeId");
  expectedElementNames.add("name");
  expectedElementNames.add("position");
  expectedElementNames.add("salary");
  expectedElementNames.add("gender");
  expectedElementNames.add("address");
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childNodes = employeeNode.getChildNodes();
  for (int indexN1006C = 0; indexN1006C < childNodes.getLength(); indexN1006C++) {
   childNode = (Node) childNodes.item(indexN1006C);
   childType = (int) childNode.getNodeType();
   if (equals(1, childType)) {
    childName = childNode.getNodeName();
    elementNames.add(childName);
   }
  }
  assertEquals(expectedElementNames, elementNames, "elementNames");
 }
}