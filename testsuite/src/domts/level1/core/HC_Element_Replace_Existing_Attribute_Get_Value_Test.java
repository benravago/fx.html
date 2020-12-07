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
* new attribute node.  The new attribute node is "class",
* which is already present in this Element.  The method
* should return the existing Attr node(old "class" Attr).
* This test uses the "createAttribute(name)" method
* from the Document interface.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154</a>
*/
@Disabled("fx")
class HC_Element_Replace_Existing_Attribute_Get_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementreplaceexistingattributegevalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Attr newAttribute;
  Attr streetAttr;
  String value;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  testEmployee = (Element) elementList.item(2);
  newAttribute = doc.createAttribute("class");
  streetAttr = testEmployee.setAttributeNode(newAttribute);
  assertNotNull(streetAttr, "previousAttrNotNull");
  value = streetAttr.getValue();
  assertEquals("No", value, "previousAttrValue");
 }
}