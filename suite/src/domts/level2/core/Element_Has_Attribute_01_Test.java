package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method hasAttribute returns true when an attribute with a given name is specified 
* on this element or has a default value, false otherwise
* Invoke the hasAttribute method to check if the documentElement has attributres.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs</a>
*/
class Element_Has_Attribute_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(false);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementhasattribute01")
 void run() throws Throwable {
  Document doc;
  Element element;
  boolean state;
  doc = (Document) load("staff", false);
  element = doc.getDocumentElement();
  state = element.hasAttribute("");
  assertFalse(state, "elementhasattribute01");
 }
}