package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The form attribute returns the FORM element containing this control. 
* Retrieve the form attribute of the 1st INPUT element and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-63239895">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-63239895</a>
*/
class HTML_Input_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vform;
  HTMLFormElement fNode;
  Document doc;
  doc = (Document) load("input", false);
  nodeList = doc.getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(0);
  fNode = ((HTMLInputElement) /*Node */testNode).getForm();
  vform = fNode.getId();
  assertEquals("form1", vform, "formLink");
 }
}