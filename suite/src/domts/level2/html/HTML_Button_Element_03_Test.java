package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The accessKey attribute returns a single character access key to
* give access to the form control. 
* Retrieve the accessKey attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-73169431">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-73169431</a>
*/
class HTML_Button_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "button", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLButtonElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vaccesskey;
  Document doc;
  doc = (Document) load("button", false);
  nodeList = doc.getElementsByTagName("button");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vaccesskey = ((HTMLButtonElement) /*Node */testNode).getAccessKey();
  assertEquals("f", vaccesskey, "accessKeyLink");
 }
}