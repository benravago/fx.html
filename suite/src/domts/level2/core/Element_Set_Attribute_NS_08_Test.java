package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setAttributeNS adds a new attribute and raises a NAMESPACE_ERR 
* if the qualifiedName, or its prefix, is "xmlns" and the namespaceURI is 
* different from "http://www.w3.org/2000/xmlns/".
* 
* Invoke the setAttributeNS method on a new Element object with namespaceURI that is 
* http://www.w3.org/DOMTest/level2 and a qualifiedName that has the prefix xmlns and once
* again with a qualifiedName that is xmlns.  
* Check if the NAMESPACE_ERR was thrown.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
*/
class Element_Set_Attribute_NS_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributens08")
 void run() throws Throwable {
  Document doc;
  Element element;
  doc = (Document) load("staffNS", true);
  element = doc.createElementNS("http://www.w3.org/DOMTest/level2", "dom:elem");
  {
   boolean success = false;
   try {
    element.setAttributeNS("http://www.w3.org/DOMTest/level2", "xmlns", "test");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "elementsetattributens08_Err1");
  }
  {
   boolean success = false;
   try {
    element.setAttributeNS("http://www.w3.org/DOMTest/level2", "xmlns:root", "test");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "elementsetattributens08_Err2");
  }
 }
}