package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttribute(name,value)" method adds a new attribute
* to the Element.  If the "strong" is already present, then
* its value should be changed to the new one that is in
* the "value" parameter. 
* 
* Retrieve the last child of the fourth employee, then add 
* an attribute to it by invoking the 
* "setAttribute(name,value)" method.  Since the name of the
* used attribute("class") is already present in this     
* element, then its value should be changed to the new one
* of the "value" parameter.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68F082">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68F082</a>
*/
class HC_Element_Change_Attribute_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementchangeattributevalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  String attrValue;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  testEmployee = (Element) elementList.item(3);
  testEmployee.setAttribute("class", "Neither");
  attrValue = testEmployee.getAttribute("class");
  assertEquals("Neither", attrValue, "elementChangeAttributeValueAssert");
 }
}