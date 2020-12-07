package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementById(elementId)" method for a 
* Document should return an element whose ID matches elementId.
* 
* Invoke method getElementById(elementId) on this document
* with elementId equals "CANADA".  Method should return an element
* whose tag name is "emp:address".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-104682815">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-104682815</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=383">http://www.w3.org/Bugs/Public/show_bug.cgi?id=383</a>
*/
class Get_Element_By_Id_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getElementById01")
 void run() throws Throwable {
  Document doc;
  Element element;
  String tagname;
  doc = (Document) load("staffNS", false);
  element = doc.getElementById("CANADA");
  tagname = element.getTagName();
  assertEquals("emp:address", tagname, "throw_Equals");
 }
}