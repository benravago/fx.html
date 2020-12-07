package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the first attribute from the last child of
* the first employee and invoke the "getSpecified()" 
* method.  This test is only intended to show that   
* Elements can actually have attributes.  This test uses  
* the "getNamedItem(name)" method from the NamedNodeMap
* interface.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
*/
class HC_Element_Associated_Attribute_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementassociatedattribute")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  NamedNodeMap attributes;
  Attr domesticAttr;
  boolean specified;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("acronym");
  testEmployee = elementList.item(0);
  attributes = testEmployee.getAttributes();
  domesticAttr = (Attr) attributes.getNamedItem("title");
  specified = domesticAttr.getSpecified();
  assertTrue(specified, "acronymTitleSpecified");
 }
}