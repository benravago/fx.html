package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Appends a text node to an attribute and clones the node.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-3A0ED0A4</a>
*/
class HC_Attr_Clone_Node_1_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_attrclonenode1")
 void run() throws Throwable {
  Document doc;
  NodeList acronymList;
  Node testNode;
  NamedNodeMap attributes;
  Attr titleAttr;
  String value;
  Text textNode;
  Node retval;
  Node lastChild;
  Attr clonedTitle;
  doc = (Document) load("hc_staff", true);
  acronymList = doc.getElementsByTagName("acronym");
  testNode = acronymList.item(3);
  attributes = testNode.getAttributes();
  titleAttr = (Attr) attributes.getNamedItem("title");
  textNode = doc.createTextNode("terday");
  retval = titleAttr.appendChild(textNode);
  clonedTitle = (Attr) titleAttr.cloneNode(false);
  textNode.setNodeValue("text_node_not_cloned");
  value = clonedTitle.getValue();
  assertEquals("Yesterday", value, "attrValue");
  value = clonedTitle.getNodeValue();
  assertEquals("Yesterday", value, "attrNodeValue");
  lastChild = clonedTitle.getLastChild();
  value = lastChild.getNodeValue();
  assertEquals("terday", value, "lastChildValue");
 }
}