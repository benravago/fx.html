package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The getElementById method returns the Element whose id is given by
* elementId.  If no such element exists, returns null.  
* Retrieve the element whose id is "mapid".
* Check the value of the element.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-36113835">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-36113835</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-26809268">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-26809268</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBId">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBId</a>
*/
class HTML_Document_15_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "document", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDocument15")
 void run() throws Throwable {
  Element elementNode;
  String elementValue;
  Document doc;
  doc = (Document) load("document", false);
  elementNode = doc.getElementById("mapid");
  elementValue = elementNode.getNodeName();
  assertTrue(equalsAutoCase("element", "map", elementValue), "elementId");
 }
}