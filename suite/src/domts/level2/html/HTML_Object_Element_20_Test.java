package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The contentDocument attribute specifies the document this object contains,
* if there is any and it is available, or null otherwise.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-38538621">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-38538621</a>
*/
class HTML_Object_Element_20_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object2", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLObjectElement20")
 void run() throws Throwable {
  Element testNode;
  Document cd;
  String vtitle;
  Document doc;
  NodeList nodeList;
  doc = (Document) load("object2", false);
  nodeList = doc.getElementsByTagName("object");
  testNode = (Element) nodeList.item(1);
  cd = ((HTMLObjectElement) /*Node */testNode).getContentDocument();
  assertNull(cd, "noContentDocument");
 }
}