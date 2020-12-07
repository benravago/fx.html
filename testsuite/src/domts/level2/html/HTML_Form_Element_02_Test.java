package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The length attribute specifies the number of form controls
* in the form. 
* Retrieve the length attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-40002357">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-40002357</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#HTML-HTMLFormElement-length">http://www.w3.org/TR/DOM-Level-2-HTML/html#HTML-HTMLFormElement-length</a>
*/
class HTML_Form_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "form", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLFormElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vlength;
  Document doc;
  doc = (Document) load("form", false);
  nodeList = doc.getElementsByTagName("form");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vlength = (int) ((HTMLFormElement) /*Node */testNode).getLength();
  assertEquals(3, vlength, "lengthLink");
 }
}