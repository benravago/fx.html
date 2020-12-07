package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Element.getElementsByTagNameNS('*','*') should return all child
* elements.  There is some contention on whether this should match
* unqualified elements, this test reflects the interpretation that
* '*' should match elements in all namespaces and unqualified elements.
* Derived from getElementsByTagNameNS01 which tests similar functionality
* on the Document interface.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1938918D">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1938918D</a>
*/
class Get_Elements_By_TagName_NS_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getElementsByTagNameNS08")
 void run() throws Throwable {
  Document doc;
  Element docElem;
  NodeList newList;
  doc = (Document) load("staffNS", false);
  docElem = doc.getDocumentElement();
  newList = docElem.getElementsByTagNameNS("*", "*");
  assertTrue(equalsSize(36, newList), "listSize");
 }
}