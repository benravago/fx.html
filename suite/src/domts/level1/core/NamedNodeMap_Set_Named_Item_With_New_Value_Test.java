package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the "setNamedItem(arg)" method does not replace an 
* existing node with the same name then it returns null. 
* 
* Retrieve the third employee and create a NamedNodeMap 
* object from the attributes of the last child.
* Once the list is created the "setNamedItem(arg)" method
* is invoked with arg=newAttr, where newAttr is a
* newly created Attr Node and whose node name
* already exists in the map.  The "setNamedItem(arg)"
* method should add the new node and return null.
* This test uses the "createAttribute(name)" method from
* the document interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9</a>
*/
class NamedNodeMap_Set_Named_Item_With_New_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/namednodemapsetnameditemwithnewvalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Attr newAttribute;
  Node testAddress;
  NamedNodeMap attributes;
  Node newNode;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testAddress = elementList.item(2);
  newAttribute = doc.createAttribute("district");
  attributes = testAddress.getAttributes();
  newNode = attributes.setNamedItem(newAttribute);
  assertNull(newNode, "returnedNodeNull");
 }
}