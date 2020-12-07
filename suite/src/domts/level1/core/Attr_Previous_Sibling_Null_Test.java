package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getPreviousSibling()" method for an Attr node should return null.
* Retrieve the attribute named "domestic" from the last child of of the
* first employee and examine its PreviousSibling node.  This test uses the
* "getNamedItem(name)" method from the NamedNodeMap interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-640FB3C8">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-640FB3C8</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024</a>
*/
class Attr_Previous_Sibling_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/attrprevioussiblingnull")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testNode;
  NamedNodeMap attributes;
  Attr domesticAttr;
  Node s;
  doc = (Document) load("staff", false);
  addressList = doc.getElementsByTagName("address");
  testNode = addressList.item(0);
  attributes = testNode.getAttributes();
  domesticAttr = (Attr) attributes.getNamedItem("domestic");
  s = domesticAttr.getPreviousSibling();
  assertNull(s, "attrPreviousSiblingNullAssert");
 }
}