package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setAttributeNS adds a new attribute and raises a NAMESPACE_ERR if the 
* qualifiedName has a prefix and the namespaceURI is null.
* Invoke the setAttributeNS method on a new Element object with null namespaceURI and a 
* qualifiedName that has a namespace prefix.  Check if the NAMESPACE_ERR was thrown.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class Element_Set_Attribute_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributens05")
 void run() throws Throwable {
  Document doc;
  Element element;
  String nullNS = null;
  doc = (Document) load("staffNS", true);
  element = doc.createElementNS("http://www.w3.org/DOM/Test/L2", "dom:elem");
  {
   boolean success = false;
   try {
    element.setAttributeNS(nullNS, "dom:root", "test");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "elementsetattributens05");
  }
 }
}