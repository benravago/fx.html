package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getOwnerElement()" will return the Element node this attribute
* is attached to or null if this attribute is not in use.  
* Create a new attribute.
* Apply the "getOwnerElement()" method to get the Element associated 
* with the attribute.  The value returned should be "null" since this
* attribute is not in use.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement">http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement</a>
*/
class Owner_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/ownerElement02")
 void run() throws Throwable {
  Document doc;
  Attr newAttr;
  Element elementNode;
  doc = (Document) load("staff", false);
  newAttr = doc.createAttribute("newAttribute");
  elementNode = newAttr.getOwnerElement();
  assertNull(elementNode, "throw_Null");
 }
}