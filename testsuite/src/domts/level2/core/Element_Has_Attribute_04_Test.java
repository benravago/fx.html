package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method hasAttribute returns true when an attribute with a given name is specified 
* on this element or has a default value, false otherwise.
* Create an element Node and an attribute Node and add the attribute node to the element.
* Invoke the hasAttribute method on the element and verify if the method returns true.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs</a>
*/
class Element_Has_Attribute_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementhasattribute04")
 void run() throws Throwable {
  Document doc;
  Element element;
  boolean state;
  Attr attribute;
  Attr newAttribute;
  doc = (Document) load("staff", false);
  element = doc.createElement("address");
  attribute = doc.createAttribute("domestic");
  newAttribute = element.setAttributeNode(attribute);
  state = element.hasAttribute("domestic");
  assertTrue(state, "elementhasattribute04");
 }
}