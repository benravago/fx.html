package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagName(name)" method may use the
* special value "*" to match all tags in the element
* tree.
* Create a NodeList of all the descendant elements
* of the last employee by using the special value "*".
* The method should return all the descendant children(6)
* in the order the children were encountered.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1938918D</a>
*/
@Disabled("fx")
class Element_Get_Elements_By_TagName_Special_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementgetelementsbytagnamespecialvalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element lastEmployee;
  NodeList lastempList;
  Node child;
  String childName;
  List result = new ArrayList();
  List expectedResult = new ArrayList();
  expectedResult.add("employeeId");
  expectedResult.add("name");
  expectedResult.add("position");
  expectedResult.add("salary");
  expectedResult.add("gender");
  expectedResult.add("address");
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("employee");
  lastEmployee = (Element) elementList.item(4);
  lastempList = lastEmployee.getElementsByTagName("*");
  for (int indexN1006A = 0; indexN1006A < lastempList.getLength(); indexN1006A++) {
   child = (Node) lastempList.item(indexN1006A);
   childName = child.getNodeName();
   result.add(childName);
  }
  assertEquals(expectedResult, result, "tagNames");
 }
}