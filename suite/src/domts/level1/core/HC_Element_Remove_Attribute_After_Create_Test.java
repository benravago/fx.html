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
* new "lang" attribute to it and then try to remove it. 
* To verify that the node was removed use the
* "getNamedItem(name)" method from the NamedNodeMap
* interface.  It also uses the "getAttributes()" method
* from the Node interface.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D589198">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D589198</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=243">http://www.w3.org/Bugs/Public/show_bug.cgi?id=243</a>
*/
class HC_Element_Remove_Attribute_After_Create_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementremoveattributeaftercreate")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Attr newAttribute;
  NamedNodeMap attributes;
  Attr districtAttr;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  testEmployee = (Element) elementList.item(2);
  newAttribute = doc.createAttribute("lang");
  districtAttr = testEmployee.setAttributeNode(newAttribute);
  districtAttr = testEmployee.removeAttributeNode(newAttribute);
  attributes = testEmployee.getAttributes();
  districtAttr = (Attr) attributes.getNamedItem("lang");
  assertNull(districtAttr, "removed_item_null");
 }
}