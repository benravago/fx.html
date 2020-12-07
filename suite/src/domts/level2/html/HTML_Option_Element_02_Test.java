package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The form attribute returns null if control in not within the context of 
* a form. 
* Retrieve the first OPTION attribute from the second select element and
* examine its form element.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-17116503">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-17116503</a>
*/
class HTML_Option_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "option", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLOptionElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLFormElement vform;
  Document doc;
  doc = (Document) load("option", false);
  nodeList = doc.getElementsByTagName("option");
  assertTrue(equalsSize(10, nodeList), "Asize");
  testNode = nodeList.item(6);
  vform = ((HTMLOptionElement) /*Node */testNode).getForm();
  assertNull(vform, "formNullLink");
 }
}