package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method removeAttributeNS removes an attribute by local name and namespace URI.
* Create a new element and add a new attribute node to it. 
* Remove the attribute node using the removeAttributeNodeNS method.  
* Check if the attribute was remove by invoking the hasAttributeNS
* method on the element and check if it returns false.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElRemAtNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElRemAtNS</a>
*/
class Element_Remove_Attribute_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementremoveattributens01")
 void run() throws Throwable {
  Document doc;
  Element element;
  boolean state;
  Attr attribute;
  Attr newAttribute;
  doc = (Document) load("staff", false);
  element = doc.createElementNS("http://www.w3.org/DOM", "elem");
  attribute = doc.createAttributeNS("http://www.w3.org/DOM/Test/createAttributeNS", "attr");
  newAttribute = element.setAttributeNodeNS(attribute);
  element.removeAttributeNS("http://www.w3.org/DOM/Test/createAttributeNS", "attr");
  state = element.hasAttributeNS("http://www.w3.org/DOM/Test/createAttributeNS", "attr");
  assertFalse(state, "elementremoveattributens01");
 }
}