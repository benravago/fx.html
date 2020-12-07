package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNode(newAttr)" method adds a new 
* attribute to the Element.  
* 
* Retrieve first address element and add
* a new attribute node to it by invoking its         
* "setAttributeNode(newAttr)" method.  This test makes use
* of the "createAttribute(name)" method from the Document
* interface.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=243">http://www.w3.org/Bugs/Public/show_bug.cgi?id=243</a>
*/
class HC_Element_Create_New_Attribute_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementcreatenewattribute")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddress;
  Attr newAttribute;
  Attr oldAttr;
  Attr districtAttr;
  String attrVal;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  testAddress = (Element) elementList.item(0);
  newAttribute = doc.createAttribute("lang");
  oldAttr = testAddress.setAttributeNode(newAttribute);
  assertNull(oldAttr, "old_attr_doesnt_exist");
  districtAttr = testAddress.getAttributeNode("lang");
  assertNotNull(districtAttr, "new_district_accessible");
  attrVal = testAddress.getAttribute("lang");
  assertEquals("", attrVal, "attr_value");
 }
}