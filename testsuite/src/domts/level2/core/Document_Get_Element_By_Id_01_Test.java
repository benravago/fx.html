package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getElementById returns the element whose ID is given by elementId.
* If not such element exists, returns null.
* 
* Invoke the getElementById method on this Document object with an invalid elementId. 
* This should return a null element.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBId">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBId</a>
*/
class Document_Get_Element_By_Id_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentgetelementbyid01")
 void run() throws Throwable {
  Document doc;
  Element element;
  String elementId = "---";
  doc = (Document) load("staffNS", false);
  element = doc.getElementById(elementId);
  assertNull(element, "documentgetelementbyid01");
 }
}