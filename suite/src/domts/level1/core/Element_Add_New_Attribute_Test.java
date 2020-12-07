package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttribute(name,value)" method adds a new attribute
* to the Element 
* 
* Retrieve the last child of the last employee, then 
* add an attribute to it by invoking the             
* "setAttribute(name,value)" method.  It should create
* a "name" attribute with an assigned value equal to 
* "value".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68F082">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68F082</a>
*/
class Element_Add_New_Attribute_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementaddnewattribute")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  String attrValue;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = (Element) elementList.item(4);
  testEmployee.setAttribute("district", "dallas");
  attrValue = testEmployee.getAttribute("district");
  assertEquals("dallas", attrValue, "elementAddNewAttributeAssert");
 }
}