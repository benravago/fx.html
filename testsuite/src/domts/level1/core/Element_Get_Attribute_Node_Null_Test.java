package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributeNode(name)" method retrieves an
* attribute node by name.  It should return null if the
* "name" attribute does not exist.
* 
* Retrieve the last child of the first employee and attempt
* to retrieve a non-existing attribute.  The method should
* return "null".  The non-existing attribute to be used
* is "invalidAttribute".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-217A91B8">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-217A91B8</a>
*/
class Element_Get_Attribute_Node_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementgetattributenodenull")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Attr domesticAttr;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = (Element) elementList.item(0);
  domesticAttr = testEmployee.getAttributeNode("invalidAttribute");
  assertNull(domesticAttr, "elementGetAttributeNodeNullAssert");
 }
}