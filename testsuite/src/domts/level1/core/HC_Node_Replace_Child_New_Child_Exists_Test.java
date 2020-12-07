package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the "newChild" is already in the tree, it is first
* removed before the new one is added.
* 
* Retrieve the second "p" and replace "acronym" with its "em".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
@Disabled("fx")
class HC_Node_Replace_Child_New_Child_Exists_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodereplacechildnewchildexists")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node employeeNode;
  NodeList childList;
  Node oldChild = null;
  Node newChild = null;
  Node child;
  String childName;
  Node childNode;
  List actual = new ArrayList();
  List expected = new ArrayList();
  expected.add("strong");
  expected.add("code");
  expected.add("sup");
  expected.add("var");
  expected.add("em");
  Node replacedChild;
  int nodeType;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("p");
  employeeNode = elementList.item(1);
  childList = ((Element) /*Node */employeeNode).getElementsByTagName("*");
  newChild = childList.item(0);
  oldChild = childList.item(5);
  replacedChild = employeeNode.replaceChild(newChild, oldChild);
  assertSame(oldChild, replacedChild, "return_value_same");
  for (int indexN10094 = 0; indexN10094 < childList.getLength(); indexN10094++) {
   childNode = (Node) childList.item(indexN10094);
   childName = childNode.getNodeName();
   nodeType = (int) childNode.getNodeType();
   if (equals(1, nodeType)) {
    actual.add(childName);
   } else {
    assertEquals(3, nodeType, "textNodeType");
    assertEquals("#text", childName, "textNodeName");
   }
  }
  assertTrue(equalsAutoCase("element", expected, actual), "childNames");
 }
}