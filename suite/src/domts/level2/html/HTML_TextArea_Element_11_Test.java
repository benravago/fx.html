package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The type attribute specifies the type of this form control.      
* Retrieve the type attribute of the 1st TEXTAREA element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-24874179">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-24874179</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#HTML-HTMLTextAreaElement-type">http://www.w3.org/TR/DOM-Level-2-HTML/html#HTML-HTMLTextAreaElement-type</a>
*/
class HTML_TextArea_Element_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "textarea", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTextAreaElement11")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vtype;
  Document doc;
  doc = (Document) load("textarea", false);
  nodeList = doc.getElementsByTagName("textarea");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtype = ((HTMLTextAreaElement) /*Node */testNode).getType();
  assertEquals("textarea", vtype, "typeLink");
 }
}