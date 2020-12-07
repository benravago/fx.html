package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The getElementsByName method returns the (possibly empty) collection
* of elements whose name value is given by the elementName.  
* Retrieve all the elements whose name attribute is "mapid".
* Check the length of the nodelist.  It should be 1.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-71555259">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-71555259</a>
*/
class HTML_Document_13_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument13")
 void run() throws Throwable {
  NodeList nodeList;
  Document doc;
  doc = (Document) load("document", false);
  nodeList = ((HTMLDocument) /*Node */doc).getElementsByName("mapid");
  assertTrue(equalsSize(1, nodeList), "Asize");
 }
}