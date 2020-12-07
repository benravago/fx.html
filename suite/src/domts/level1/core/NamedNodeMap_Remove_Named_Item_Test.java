package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeNamedItem(name)" method removes a node 
* specified by name. 
* 
* Retrieve the third employee and create a NamedNodeMap 
* object of the attributes of the last child.  Once the
* list is created invoke the "removeNamedItem(name)"
* method with name="street".  This should result
* in the removal of the specified attribute and
* the "getSpecified()" method should return false.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D58B193">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D58B193</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html">http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html</a>
*/
@Disabled("fx")
class NamedNodeMap_Remove_Named_Item_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/namednodemapremovenameditem")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testAddress;
  NamedNodeMap attributes;
  Attr streetAttr;
  boolean specified;
  Node removedNode;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testAddress = elementList.item(2);
  attributes = testAddress.getAttributes();
  assertNotNull(attributes, "attributesNotNull");
  removedNode = attributes.removeNamedItem("street");
  streetAttr = (Attr) attributes.getNamedItem("street");
  assertNotNull(streetAttr, "streetAttrNotNull");
  specified = streetAttr.getSpecified();
  assertFalse(specified, "attrNotSpecified");
 }
}