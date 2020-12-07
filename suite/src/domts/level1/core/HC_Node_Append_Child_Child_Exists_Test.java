package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the "newChild" is already in the tree, it is first
* removed before the new one is appended.
* 
* Retrieve the "em" second employee and   
* append the first child to the end of the list.   After
* the "appendChild(newChild)" method is invoked the first 
* child should be the one that was second and the last
* child should be the one that was first.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=246">http://www.w3.org/Bugs/Public/show_bug.cgi?id=246</a>
*/
@Disabled("fx")
class HC_Node_Append_Child_Child_Exists_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeappendchildchildexists")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  NodeList childList;
  Node childNode;
  Node newChild;
  Node memberNode;
  String memberName;
  List refreshedActual = new ArrayList();
  List actual = new ArrayList();
  int nodeType;
  List expected = new ArrayList();
  expected.add("strong");
  expected.add("code");
  expected.add("sup");
  expected.add("var");
  expected.add("acronym");
  expected.add("em");
  Node appendedChild;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("p");
  childNode = elementList.item(1);
  childList = ((Element) /*Node */childNode).getElementsByTagName("*");
  newChild = childList.item(0);
  appendedChild = childNode.appendChild(newChild);
  for (int indexN10085 = 0; indexN10085 < childList.getLength(); indexN10085++) {
   memberNode = (Node) childList.item(indexN10085);
   memberName = memberNode.getNodeName();
   actual.add(memberName);
  }
  assertTrue(equalsAutoCase("element", expected, actual), "liveByTagName");
  childList = childNode.getChildNodes();
  for (int indexN1009C = 0; indexN1009C < childList.getLength(); indexN1009C++) {
   memberNode = (Node) childList.item(indexN1009C);
   nodeType = (int) memberNode.getNodeType();
   if (equals(1, nodeType)) {
    memberName = memberNode.getNodeName();
    refreshedActual.add(memberName);
   }
  }
  assertTrue(equalsAutoCase("element", expected, refreshedActual), "refreshedChildNodes");
 }
}