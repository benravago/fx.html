package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setPrefix raises a NAMESPACE_ERR if this node is an attribute and the specified 
* prefix is "xmlns" and the namespaceURI of this node is different from 
* "http://www.w3.org/2000/xmlns/".
* Create a new attribute node whose namespaceURI is different form "http://www.w3.org/2000/xmlns/"
* and node prefix is "xmlns".
* Check if the NAMESPACE_ERR was thrown.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Node_Set_Prefix_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodesetprefix07")
 void run() throws Throwable {
  Document doc;
  Attr attribute;
  doc = (Document) load("staffNS", true);
  attribute = doc.createAttributeNS("http://www.w3.org/DOM/Test/L2", "abc:elem");
  {
   boolean success = false;
   try {
    attribute.setPrefix("xmlns");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "throw_NAMESPACE_ERR");
  }
 }
}