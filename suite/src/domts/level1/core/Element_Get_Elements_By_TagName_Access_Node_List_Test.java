package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Element.getElementsByTagName("employee") should return a NodeList whose length is
* "5" in the order the children were encountered.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D</a>
*/
class Element_Get_Elements_By_TagName_Access_Node_List_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementgetelementsbytagnameaccessnodelist")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Node child;
  String childName;
  String childValue;
  int childType;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  testEmployee = (Element) elementList.item(3);
  child = testEmployee.getFirstChild();
  childType = (int) child.getNodeType();
  if (equals(3, childType)) {
   child = child.getNextSibling();
  }
  childName = child.getNodeName();
  assertEquals("employeeId", childName, "nodename");
  child = child.getFirstChild();
  childValue = child.getNodeValue();
  assertEquals("EMP0004", childValue, "emp0004");
 }
}