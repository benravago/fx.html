package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setPrefix raises a NAMESPACE_ERR if this node is an attribute and the qualifiedName 
* of this node is "xmlns
* Retreive an attribute node whose qualifiedName is xmlns.  Try setting a prefix on this node.
* Check if the NAMESPACE_ERR was thrown.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Node_Set_Prefix_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodesetprefix08")
 void run() throws Throwable {
  Document doc;
  Element element;
  NodeList elementList;
  Attr attribute;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("employee");
  element = (Element) elementList.item(0);
  attribute = element.getAttributeNode("xmlns");
  {
   boolean success = false;
   try {
    attribute.setPrefix("xml");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "throw_NAMESPACE_ERR");
  }
 }
}