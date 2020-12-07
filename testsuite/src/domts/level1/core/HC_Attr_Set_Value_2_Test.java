package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Sets Attr.value on an attribute that should contain multiple child nodes.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-221662474">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-221662474</a>
*/
class HC_Attr_Set_Value_2_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_attrsetvalue2")
 void run() throws Throwable {
  Document doc;
  NodeList acronymList;
  Node testNode;
  NamedNodeMap attributes;
  Attr titleAttr;
  String value;
  Text textNode;
  Node retval;
  Node firstChild;
  Node otherChild;
  doc = (Document) load("hc_staff", true);
  acronymList = doc.getElementsByTagName("acronym");
  testNode = acronymList.item(3);
  attributes = testNode.getAttributes();
  titleAttr = (Attr) attributes.getNamedItem("title");
  textNode = doc.createTextNode("terday");
  retval = titleAttr.appendChild(textNode);
  firstChild = titleAttr.getFirstChild();
  assertNotNull(firstChild, "attrChildNotNull");
  titleAttr.setValue("Tomorrow");
  firstChild.setNodeValue("impl reused node");
  value = titleAttr.getValue();
  assertEquals("Tomorrow", value, "attrValue");
  value = titleAttr.getNodeValue();
  assertEquals("Tomorrow", value, "attrNodeValue");
  firstChild = titleAttr.getLastChild();
  value = firstChild.getNodeValue();
  assertEquals("Tomorrow", value, "firstChildValue");
  otherChild = firstChild.getNextSibling();
  assertNull(otherChild, "nextSiblingIsNull");
 }
}