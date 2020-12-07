package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getOwnerElement()" will return the Element node this attribute
* is attached to or null if this attribute is not in use.  
* 
* Create a new attribute node for this document node.  Since the newly attribute is
* not it use its owner element should be null.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement">http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement</a>
*/
class Attr_Get_Owner_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/attrgetownerelement03")
 void run() throws Throwable {
  Document doc;
  Node ownerElement;
  Attr attr;
  doc = (Document) load("staffNS", false);
  attr = doc.createAttributeNS("http://www.w3.org/DOM", "dom:attr");
  ownerElement = attr.getOwnerElement();
  assertNull(ownerElement, "attrgetownerelement03");
 }
}