package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The getNodeName() method of an Attribute node. 
* Retrieve the attribute named street from the last 
* child of of the second employee and examine its 
* NodeName.  This test uses the getNamedItem(name) method from the NamedNodeMap 
* interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1112119403">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1112119403</a>
*/
class Attr_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/attrname")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testNode;
  NamedNodeMap attributes;
  Attr streetAttr;
  String name;
  doc = (Document) load("staff", false);
  addressList = doc.getElementsByTagName("address");
  testNode = addressList.item(1);
  attributes = testNode.getAttributes();
  streetAttr = (Attr) attributes.getNamedItem("street");
  name = streetAttr.getNodeName();
  assertEquals("street", name, "nodeName");
  name = streetAttr.getName();
  assertEquals("street", name, "name");
 }
}