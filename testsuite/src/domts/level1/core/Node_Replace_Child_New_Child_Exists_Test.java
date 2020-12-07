package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the second employee and replace its TWELFTH 
* child(address) with its SECOND child(employeeId).   After the
* replacement the second child should now be the one that used   
* to be at the third position and the TWELFTH child should be the
* one that used to be at the SECOND position.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307</a>
*/
@Disabled("fx")
class Node_Replace_Child_New_Child_Exists_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodereplacechildnewchildexists")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node oldChild = null;
  Node newChild = null;
  String childName;
  Node childNode;
  int length;
  List actual = new ArrayList();
  List expected = new ArrayList();
  List expectedWithoutWhitespace = new ArrayList();
  expectedWithoutWhitespace.add("name");
  expectedWithoutWhitespace.add("position");
  expectedWithoutWhitespace.add("salary");
  expectedWithoutWhitespace.add("gender");
  expectedWithoutWhitespace.add("employeeId");
  List expectedWithWhitespace = new ArrayList();
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("name");
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("position");
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("salary");
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("gender");
  expectedWithWhitespace.add("#text");
  expectedWithWhitespace.add("employeeId");
  expectedWithWhitespace.add("#text");
  Node replacedChild;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("employee");
  employeeNode = elementList.item(1);
  childList = employeeNode.getChildNodes();
  length = (int) childList.getLength();
  if (equals(13, length)) {
   newChild = childList.item(1);
   oldChild = childList.item(11);
   expected = expectedWithWhitespace;
  } else {
   newChild = childList.item(0);
   oldChild = childList.item(5);
   expected = expectedWithoutWhitespace;
  }
  replacedChild = employeeNode.replaceChild(newChild, oldChild);
  assertSame(oldChild, replacedChild, "return_value_same");
  for (int indexN100DE = 0; indexN100DE < childList.getLength(); indexN100DE++) {
   childNode = (Node) childList.item(indexN100DE);
   childName = childNode.getNodeName();
   actual.add(childName);
  }
  assertEquals(expected, actual, "childNames");
 }
}