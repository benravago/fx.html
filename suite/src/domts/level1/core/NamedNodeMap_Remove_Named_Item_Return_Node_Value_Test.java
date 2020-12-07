package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeNamedItem(name)" method returns the node
* removed from the map.  
* 
* Retrieve the third employee and create a NamedNodeMap 
* object of the attributes of the last child.  Once the
* list is created invoke the "removeNamedItem(name)"
* method with name="street".  The "removeNamedItem(name)"
* method should remove the existing "street" attribute
* and return it.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D58B193">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D58B193</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9</a>
*/
class NamedNodeMap_Remove_Named_Item_Return_Node_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/namednodemapremovenameditemreturnnodevalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testAddress;
  NamedNodeMap attributes;
  Node removedNode;
  String value;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testAddress = elementList.item(2);
  attributes = testAddress.getAttributes();
  removedNode = attributes.removeNamedItem("street");
  value = removedNode.getNodeValue();
  assertEquals("No", value, "namednodemapRemoveNamedItemReturnNodeValueAssert");
 }
}