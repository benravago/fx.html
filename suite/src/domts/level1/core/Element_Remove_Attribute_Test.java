package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeAttribute(name)" removes an attribute by name.
* If the attribute has a default value, it is immediately
* replaced.
* 
* Retrieve the attribute named "street" from the last child
* of the fourth employee, then remove the "street" 
* attribute by invoking the "removeAttribute(name)" method.
* The "street" attribute has a default value defined in the
* DTD file, that value should immediately replace the old
* value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D6AC0F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D6AC0F9</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html">http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html</a>
*/
@Disabled("fx")
class Element_Remove_Attribute_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementremoveattribute")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  String attrValue;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = (Element) elementList.item(3);
  testEmployee.removeAttribute("street");
  attrValue = testEmployee.getAttribute("street");
  assertEquals("Yes", attrValue, "streetYes");
 }
}