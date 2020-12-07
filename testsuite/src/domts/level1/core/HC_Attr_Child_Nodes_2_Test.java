package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Checks Node.childNodes for an attribute with multiple child nodes.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1451460987</a>
*/
class HC_Attr_Child_Nodes_2_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_attrchildnodes2")
 void run() throws Throwable {
  Document doc;
  NodeList acronymList;
  Node testNode;
  NamedNodeMap attributes;
  Attr titleAttr;
  String value;
  Text textNode;
  NodeList childNodes;
  Node retval;
  doc = (Document) load("hc_staff", true);
  acronymList = doc.getElementsByTagName("acronym");
  testNode = acronymList.item(3);
  attributes = testNode.getAttributes();
  titleAttr = (Attr) attributes.getNamedItem("title");
  childNodes = titleAttr.getChildNodes();
  textNode = doc.createTextNode("terday");
  retval = titleAttr.appendChild(textNode);
  assertTrue(equalsSize(2, childNodes), "childNodesSize");
  textNode = (Text) childNodes.item(0);
  value = textNode.getNodeValue();
  assertEquals("Yes", value, "child1IsYes");
  textNode = (Text) childNodes.item(1);
  value = textNode.getNodeValue();
  assertEquals("terday", value, "child2IsTerday");
  textNode = (Text) childNodes.item(2);
  assertNull(textNode, "thirdItemIsNull");
 }
}