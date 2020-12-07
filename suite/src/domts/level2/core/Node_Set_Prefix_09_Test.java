package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setPrefix raises a INVALID_CHARACTER_ERR if the specified prefix contains an illegal character.
* Create a new namespace aware element node and call the setPrefix method on it with a prefix having 
* an invalid character.  Check if a NAMESPACE_ERR is thrown.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Node_Set_Prefix_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodesetprefix09")
 void run() throws Throwable {
  Document doc;
  String value = "#$%&'()@";
  Element element;
  doc = (Document) load("staffNS", true);
  element = doc.createElementNS("http://www.w3.org/DOM/Test/L2", "dom:elem");
  {
   boolean success = false;
   try {
    element.setPrefix(value);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
   }
   assertTrue(success, "throw_INVALID_CHARACTER_ERR");
  }
 }
}