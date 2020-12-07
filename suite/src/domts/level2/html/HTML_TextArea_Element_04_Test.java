package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The accessKey attribute specifies a single character access key to 
* give access to the form control.
* Retrieve the accessKey attribute of the 1st TEXTAREA element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-93102991">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-93102991</a>
*/
class HTML_TextArea_Element_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "textarea", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTextAreaElement04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vaccesskey;
  Document doc;
  doc = (Document) load("textarea", false);
  nodeList = doc.getElementsByTagName("textarea");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  vaccesskey = ((HTMLTextAreaElement) /*Node */testNode).getAccessKey();
  assertEquals("c", vaccesskey, "accessKeyLink");
 }
}