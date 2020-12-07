package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Creates an new attribute node and appends a text node.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107</a>
*/
class HC_Attr_Append_Child_6_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_attrappendchild6")
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
  doc = (Document) load("hc_staff", true);
  titleAttr = doc.createAttribute("title");
  textNode = doc.createTextNode("Yesterday");
  retval = titleAttr.appendChild(textNode);
  value = titleAttr.getValue();
  assertEquals("Yesterday", value, "attrValue");
  value = titleAttr.getNodeValue();
  assertEquals("Yesterday", value, "attrNodeValue");
  value = retval.getNodeValue();
  assertEquals("Yesterday", value, "retvalValue");
  lastChild = titleAttr.getLastChild();
  value = lastChild.getNodeValue();
  assertEquals("Yesterday", value, "lastChildValue");
 }
}