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
* a "strong" attribute with an assigned value equal to 
* "value".
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68F082">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68F082</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=243">http://www.w3.org/Bugs/Public/show_bug.cgi?id=243</a>
*/
class HC_Element_Add_New_Attribute_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementaddnewattribute")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  String attrValue;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  testEmployee = (Element) elementList.item(4);
  testEmployee.setAttribute("lang", "EN-us");
  attrValue = testEmployee.getAttribute("lang");
  assertEquals("EN-us", attrValue, "attrValue");
 }
}