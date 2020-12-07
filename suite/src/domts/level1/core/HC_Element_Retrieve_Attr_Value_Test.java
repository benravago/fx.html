package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttribute(name)" method returns an attribute
* value by name.
* 
* Retrieve the second address element, then
* invoke the 'getAttribute("class")' method.  This should
* return the value of the attribute("No").
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-666EE0F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-666EE0F9</a>
*/
class HC_Element_Retrieve_Attr_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementretrieveattrvalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddress;
  String attrValue;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("acronym");
  testAddress = (Element) elementList.item(2);
  attrValue = testAddress.getAttribute("class");
  assertEquals("No", attrValue, "attrValue");
 }
}