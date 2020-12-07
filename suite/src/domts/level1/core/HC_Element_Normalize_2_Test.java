package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Add an empty text node to an existing attribute node, normalize the containing element
* and check that the attribute node has eliminated the empty text.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-162CF083">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-162CF083</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=482">http://www.w3.org/Bugs/Public/show_bug.cgi?id=482</a>
*/
@Disabled("fx")
class HC_Element_Normalize_2_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementnormalize2")
 void run() throws Throwable {
  Document doc;
  Element root;
  NodeList elementList;
  Element element;
  Node firstChild;
  Node secondChild;
  String childValue;
  Text emptyText;
  Attr attrNode;
  Node retval;
  doc = (Document) load("hc_staff", true);
  root = doc.getDocumentElement();
  emptyText = doc.createTextNode("");
  elementList = root.getElementsByTagName("acronym");
  element = (Element) elementList.item(0);
  attrNode = element.getAttributeNode("title");
  retval = attrNode.appendChild(emptyText);
  element.normalize();
  attrNode = element.getAttributeNode("title");
  firstChild = attrNode.getFirstChild();
  childValue = firstChild.getNodeValue();
  assertEquals("Yes", childValue, "firstChild");
  secondChild = firstChild.getNextSibling();
  assertNull(secondChild, "secondChildNull");
 }
}