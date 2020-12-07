package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNode(newAttr)" method adds a new
* attribute to the Element.  If the "newAttr" Attr node is
* already present in this element, it should replace the
* existing one. 
* 
* Retrieve the last child of the third employee and add a 
* new attribute node by invoking the "setAttributeNode(new 
* Attr)" method.  The new attribute node to be added is 
* "street", which is already present in this element.  The
* method should replace the existing Attr node with the 
* new one.  This test uses the "createAttribute(name)"
* method from the Document interface. 
* @author NIST
* @author Mary Brady
*/
@Disabled("fx")
class Element_Replace_Existing_Attribute_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementreplaceexistingattribute")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Attr newAttribute;
  String name;
  Attr setAttr;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = (Element) elementList.item(2);
  newAttribute = doc.createAttribute("street");
  setAttr = testEmployee.setAttributeNode(newAttribute);
  name = testEmployee.getAttribute("street");
  assertEquals("", name, "elementReplaceExistingAttributeAssert");
 }
}