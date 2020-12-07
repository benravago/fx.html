package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method hasAttributeNS returns true when an attribute with a given local name 
* and namespace URI is specified on this element or has a default value, 
* false otherwise. 
* 
* Create a new element and an attribute node that has an empty namespace.  
* Add the attribute node to the element node.  Check if the newly created element 
* node has an attribute by invoking the hasAttributeNS method with appropriate 
* values for the namespaceURI and localName parameters.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttrNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class Element_Has_Attribute_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementhasattributens03")
 void run() throws Throwable {
  Document doc;
  Element element;
  boolean state;
  Attr attribute;
  Attr newAttribute;
  String nullNS = null;
  doc = (Document) load("staff", false);
  element = doc.createElementNS("http://www.w3.org/DOM", "address");
  assertNotNull(element, "createElementNotNull");
  attribute = doc.createAttributeNS(nullNS, "domestic");
  newAttribute = element.setAttributeNode(attribute);
  state = element.hasAttributeNS(nullNS, "domestic");
  assertTrue(state, "elementhasattributens03");
 }
}