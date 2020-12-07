package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* If the "setAttributeNode(newAttr)" method replaces an
* existing Attr node with the same name, then it should
* return the previously existing Attr node.
* Retrieve the last child of the third employee and add a
* new attribute node.  The new attribute node is "street",
* which is already present in this Element.  The method
* should return the existing Attr node(old "street" Attr).
* This test uses the "createAttribute(name)" method
* from the Document interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154</a>
*/
@Disabled("fx")
class Element_Replace_Existing_Attribute_Get_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementreplaceexistingattributegevalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Attr newAttribute;
  Attr streetAttr;
  String value;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = (Element) elementList.item(2);
  newAttribute = doc.createAttribute("street");
  streetAttr = testEmployee.setAttributeNode(newAttribute);
  value = streetAttr.getValue();
  assertEquals("No", value, "streetNo");
 }
}