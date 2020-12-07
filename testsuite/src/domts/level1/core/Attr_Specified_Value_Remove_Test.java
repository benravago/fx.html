package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* To respecify the attribute to its default value from
* the DTD, the attribute must be deleted.  This will then
* make a new attribute available with the "getSpecified()"
* method value set to false.
* Retrieve the attribute named "street" from the last
* child of of the THIRD employee and delete it.  This
* should then create a new attribute with its default
* value and also cause the "getSpecified()" method to
* return false.
* This test uses the "removeAttribute(name)" method
* from the Element interface and the "getNamedItem(name)"
* method from the NamedNodeMap interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D6AC0F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D6AC0F9</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html">http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html</a>
*/
@Disabled("fx")
class Attr_Specified_Value_Remove_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/attrspecifiedvalueremove")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testNode;
  NamedNodeMap attributes;
  Attr streetAttr;
  boolean state;
  doc = (Document) load("staff", true);
  addressList = doc.getElementsByTagName("address");
  testNode = addressList.item(2);
  ((Element) /*Node */testNode).removeAttribute("street");
  attributes = testNode.getAttributes();
  streetAttr = (Attr) attributes.getNamedItem("street");
  assertNotNull(streetAttr, "streetAttrNotNull");
  state = streetAttr.getSpecified();
  assertFalse(state, "attrSpecifiedValueRemoveAssert");
 }
}