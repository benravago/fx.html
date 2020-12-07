package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The accept attribute is a comma-seperated list of content types that
* a server processing this form will handle correctly.
* Retrieve the accept attribute of the 9th INPUT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-15328520">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-15328520</a>
*/
class HTML_Input_Element_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vaccept;
  Document doc;
  doc = (Document) load("input", false);
  nodeList = doc.getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(8);
  vaccept = ((HTMLInputElement) /*Node */testNode).getAccept();
  assertEquals("GIF,JPEG", vaccept, "acceptLink");
 }
}