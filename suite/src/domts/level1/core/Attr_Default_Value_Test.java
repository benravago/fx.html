package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If there is not an explicit value assigned to an attribute
* and there is a declaration for this attribute and that
* declaration includes a default value, then that default
* value is the attributes default value.
* Retrieve the attribute named "street" from the last 
* child of of the first employee and examine its 
* value.  That value should be the value given the
* attribute in the DTD file.  The test uses the 
* "getNamedItem(name)" method from the NamedNodeMap 
* interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1074577549">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1074577549</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html">http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html</a>
*/
class Attr_Default_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/attrdefaultvalue")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testNode;
  NamedNodeMap attributes;
  Attr streetAttr;
  String value;
  doc = (Document) load("staff", false);
  addressList = doc.getElementsByTagName("address");
  testNode = addressList.item(0);
  attributes = testNode.getAttributes();
  streetAttr = (Attr) attributes.getNamedItem("street");
  value = streetAttr.getNodeValue();
  assertEquals("Yes", value, "attrDefaultValueAssert");
 }
}