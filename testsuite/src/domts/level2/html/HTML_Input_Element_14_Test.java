package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The src attribute specifies the location of the image to decorate the
* graphical submit button when the type has the value Image.
* Retrieve the src attribute of the 8th INPUT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-97320704">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-97320704</a>
*/
class HTML_Input_Element_14_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement14")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vsrc;
  Document doc;
  doc = (Document) load("input", false);
  nodeList = doc.getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(7);
  vsrc = ((HTMLInputElement) /*Node */testNode).getSrc();
  assertTrue(equalsURI(null, null, null, "submit.gif", null, null, null, null, vsrc), "srcLink");
 }
}