package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Replaces a text node of an attribute with a document fragment and checks if the value of
* the attribute is changed.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-785887307</a>
*/
@Disabled("fx")
class HC_Attr_Replace_Child_2_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_attrreplacechild2")
 void run() throws Throwable {
  Document doc;
  NodeList acronymList;
  Node testNode;
  NamedNodeMap attributes;
  Attr titleAttr;
  String value;
  Text terNode;
  Text dayNode;
  DocumentFragment docFrag;
  Node retval;
  Node firstChild;
  doc = (Document) load("hc_staff", true);
  acronymList = doc.getElementsByTagName("acronym");
  testNode = acronymList.item(3);
  attributes = testNode.getAttributes();
  titleAttr = (Attr) attributes.getNamedItem("title");
  terNode = doc.createTextNode("ter");
  dayNode = doc.createTextNode("day");
  docFrag = doc.createDocumentFragment();
  retval = docFrag.appendChild(terNode);
  retval = docFrag.appendChild(dayNode);
  firstChild = titleAttr.getFirstChild();
  assertNotNull(firstChild, "attrChildNotNull");
  retval = titleAttr.replaceChild(docFrag, firstChild);
  value = titleAttr.getValue();
  assertEquals("terday", value, "attrValue");
  value = titleAttr.getNodeValue();
  assertEquals("terday", value, "attrNodeValue");
  value = retval.getNodeValue();
  assertEquals("Yes", value, "retvalValue");
  firstChild = titleAttr.getFirstChild();
  value = firstChild.getNodeValue();
  assertEquals("ter", value, "firstChildValue");
 }
}