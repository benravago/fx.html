package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNode(newAttr)" method returns the
* null value if no previously existing Attr node with the
* same name was replaced.
* 
* Retrieve the last child of the third employee and add a 
* new attribute to it.  The new attribute node added is 
* "lang", which is not part of this Element.  The   
* method should return the null value.   
* This test uses the "createAttribute(name)"
* method from the Document interface. 
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=243">http://www.w3.org/Bugs/Public/show_bug.cgi?id=243</a>
*/
class HC_Element_Set_Attribute_Node_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementsetattributenodenull")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Attr newAttribute;
  Attr districtAttr;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  testEmployee = (Element) elementList.item(2);
  newAttribute = doc.createAttribute("lang");
  districtAttr = testEmployee.setAttributeNode(newAttribute);
  assertNull(districtAttr, "elementSetAttributeNodeNullAssert");
 }
}