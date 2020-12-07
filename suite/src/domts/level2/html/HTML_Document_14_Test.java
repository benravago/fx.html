package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The getElementsByName method returns the (possibly empty) collection
* of elements whose name value is given by the elementName.  
* Retrieve all the elements whose name attribute is "noid".
* Check the length of the nodelist.  It should be 0 since
* the id "noid" does not exist.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-71555259">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-71555259</a>
*/
class HTML_Document_14_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument14")
 void run() throws Throwable {
  NodeList nodeList;
  Document doc;
  doc = (Document) load("document", false);
  nodeList = ((HTMLDocument) /*Node */doc).getElementsByName("noid");
  assertTrue(equalsSize(0, nodeList), "Asize");
 }
}