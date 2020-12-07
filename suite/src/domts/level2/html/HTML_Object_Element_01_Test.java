package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The form attribute returns the FORM element containing this control. 
* Retrieve the form attribute and examine its value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-46094773">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-46094773</a>
*/
class HTML_Object_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object2", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLObjectElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLFormElement fNode;
  String vform;
  Document doc;
  doc = (Document) load("object2", false);
  nodeList = doc.getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(1);
  fNode = ((HTMLObjectElement) /*Node */testNode).getForm();
  vform = fNode.getId();
  assertEquals("object2", vform, "idLink");
 }
}