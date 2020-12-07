package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getAttributeNode(name)" method retrieves an
* attribute node by name.
* 
* Retrieve the attribute "domestic" from the last child
* of the first employee.  Since the method returns an
* Attr object, the "name" can be examined to ensure the
* proper attribute was retrieved.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-217A91B8">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-217A91B8</a>
*/
class Element_Get_Attribute_Node_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementgetattributenode")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Attr domesticAttr;
  String name;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = (Element) elementList.item(0);
  domesticAttr = testEmployee.getAttributeNode("domestic");
  name = domesticAttr.getNodeName();
  assertEquals("domestic", name, "elementGetAttributeNodeAssert");
 }
}