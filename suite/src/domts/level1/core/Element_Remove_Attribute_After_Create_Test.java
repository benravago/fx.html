package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeAttributeNode(oldAttr)" method removes the 
* specified attribute. 
* 
* Retrieve the last child of the third employee, add a
* new "district" node to it and then try to remove it. 
* To verify that the node was removed use the
* "getNamedItem(name)" method from the NamedNodeMap
* interface.  It also uses the "getAttributes()" method
* from the Node interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D589198">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D589198</a>
*/
class Element_Remove_Attribute_After_Create_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementremoveattributeaftercreate")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Attr newAttribute;
  NamedNodeMap attributes;
  Attr districtAttr;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = (Element) elementList.item(2);
  newAttribute = doc.createAttribute("district");
  districtAttr = testEmployee.setAttributeNode(newAttribute);
  districtAttr = testEmployee.removeAttributeNode(newAttribute);
  attributes = testEmployee.getAttributes();
  districtAttr = (Attr) attributes.getNamedItem("district");
  assertNull(districtAttr, "elementRemoveAttributeAfterCreateAssert");
 }
}