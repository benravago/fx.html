package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method hasAttribute returns true when an attribute with a given name is specified 
* on this element or has a default value, false otherwise
* Invoke the hasAttribute method to on an element with default attributes and verify if it
* returns true.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs</a>
*/
class Element_Has_Attribute_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementhasattribute02")
 void run() throws Throwable {
  Document doc;
  Element element;
  boolean state;
  NodeList elementList;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("emp:employee");
  element = (Element) elementList.item(0);
  assertNotNull(element, "empEmployeeNotNull");
  state = element.hasAttribute("defaultAttr");
  assertTrue(state, "elementhasattribute02");
 }
}