package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttribute(name)" method returns an empty 
* string if no value was assigned to an attribute and 
* no default value was given in the DTD file.
* 
* Retrieve the last child of the last employee, then
* invoke "getAttribute(name)" method, where "name" is an
* attribute without a specified or DTD default value. 
* The "getAttribute(name)" method should return the empty
* string.  This method makes use of the
* "createAttribute(newAttr)" method from the Document
* interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-666EE0F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-666EE0F9</a>
*/
class Element_Get_Element_Empty_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementgetelementempty")
 void run() throws Throwable {
  Document doc;
  Attr newAttribute;
  NodeList elementList;
  Element testEmployee;
  Attr domesticAttr;
  String attrValue;
  doc = (Document) load("staff", true);
  newAttribute = doc.createAttribute("district");
  elementList = doc.getElementsByTagName("address");
  testEmployee = (Element) elementList.item(3);
  domesticAttr = testEmployee.setAttributeNode(newAttribute);
  attrValue = testEmployee.getAttribute("district");
  assertEquals("", attrValue, "elementGetElementEmptyAssert");
 }
}