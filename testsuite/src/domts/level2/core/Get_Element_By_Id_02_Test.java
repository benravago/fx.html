package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* 
* The "getElementById(elementId)" method for a 
* Document should return null if elementId does not identify any
* elements in this document.
* 
* Invoke method getElementById(elementId) on this document
* with elementId equals "Cancun". Method should return null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBId">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBId</a>
*/
class Get_Element_By_Id_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getElementById02")
 void run() throws Throwable {
  Document doc;
  Element element;
  doc = (Document) load("staffNS", false);
  element = doc.getElementById("Cancun");
  assertNull(element, "throw_Null");
 }
}