package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Checks that Node.firstChild for an attribute node contains
* the expected text node.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-169727388">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-169727388</a>
*/
class HC_Attr_First_Child_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_attrfirstchild")
 void run() throws Throwable {
  Document doc;
  NodeList acronymList;
  Node testNode;
  NamedNodeMap attributes;
  Attr titleAttr;
  String value;
  Text textNode;
  Node otherChild;
  doc = (Document) load("hc_staff", true);
  acronymList = doc.getElementsByTagName("acronym");
  testNode = acronymList.item(3);
  attributes = testNode.getAttributes();
  titleAttr = (Attr) attributes.getNamedItem("title");
  textNode = (Text) titleAttr.getFirstChild();
  assertNotNull(textNode, "textNodeNotNull");
  value = textNode.getNodeValue();
  assertEquals("Yes", value, "child1IsYes");
  otherChild = textNode.getNextSibling();
  assertNull(otherChild, "nextSiblingIsNull");
  otherChild = textNode.getPreviousSibling();
  assertNull(otherChild, "previousSiblingIsNull");
 }
}