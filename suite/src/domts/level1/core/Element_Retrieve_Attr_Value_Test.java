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
* invoke the 'getAttribute("street")' method.  This should
* return the value of the attribute("No").
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-666EE0F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-666EE0F9</a>
*/
class Element_Retrieve_Attr_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementretrieveattrvalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddress;
  String attrValue;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  testAddress = (Element) elementList.item(2);
  attrValue = testAddress.getAttribute("street");
  assertEquals("No", attrValue, "attrValue");
 }
}