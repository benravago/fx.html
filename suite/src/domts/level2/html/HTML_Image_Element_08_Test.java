package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The longDesc attribute contains an URI designating a long description
* of this image or frame.
* Retrieve the longDesc attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-77376969">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-77376969</a>
*/
class HTML_Image_Element_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "img", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLImageElement08")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vlongdesc;
  Document doc;
  doc = (Document) load("img", false);
  nodeList = doc.getElementsByTagName("img");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vlongdesc = ((HTMLImageElement) /*Node */testNode).getLongDesc();
  assertTrue(equalsURI(null, null, null, "desc.html", null, null, null, null, vlongdesc), "longDescLink");
 }
}