package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setPrefix raises a NAMESPACE_ERR if the specified prefix is "xml" and the namespaceURI 
* of this node is different from "http://www.w3.org/XML/1998/namespace".
* Invoke the setPrefix method on this Element object with namespaceURI that is different from
* http://www..w3.org/xml/1998/namespace and a prefix whose values is xml.  
* Check if the NAMESPACE_ERR was thrown.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Node_Set_Prefix_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodesetprefix06")
 void run() throws Throwable {
  Document doc;
  Element element;
  doc = (Document) load("staffNS", true);
  element = doc.createElementNS("http://www.w3.org/DOM/Test/L2", "dom:elem");
  {
   boolean success = false;
   try {
    element.setPrefix("xml");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "throw_NAMESPACE_ERR");
  }
 }
}