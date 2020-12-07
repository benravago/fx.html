package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the "setNamedItem(arg)" method replaces an already 
* existing node with the same name then the already 
* existing node is returned.
* 
* Retrieve the third employee and create a NamedNodeMap 
* object from the attributes of the last child by
* invoking the "getAttributes()" method.  Once the
* list is created an invocation of the "setNamedItem(arg)"
* method is done with arg=newAttr, where newAttr is a
* new Attr Node previously created and whose node name
* already exists in the map.  The "setNamedItem(arg)"
* method should replace the already existing node with
* the new one and return the existing node.   
* This test uses the "createAttribute(name)" method from
* the document interface.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9</a>
*/
@Disabled("fx")
class HC_NamedNodeMap_Set_Named_Item_Return_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_namednodemapsetnameditemreturnvalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Attr newAttribute;
  Node testAddress;
  NamedNodeMap attributes;
  Node newNode;
  String attrValue;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  testAddress = elementList.item(2);
  newAttribute = doc.createAttribute("class");
  attributes = testAddress.getAttributes();
  newNode = attributes.setNamedItem(newAttribute);
  assertNotNull(newNode, "previousAttrNotNull");
  attrValue = newNode.getNodeValue();
  assertEquals("No", attrValue, "previousAttrValue");
 }
}