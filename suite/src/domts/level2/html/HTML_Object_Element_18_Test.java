package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The name attribute specifies form control or object name when submitted
* with a form.
* Retrieve the name attribute of the second OBJECT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-20110362">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-20110362</a>
*/
class HTML_Object_Element_18_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLObjectElement18")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vname;
  Document doc;
  doc = (Document) load("object", false);
  nodeList = doc.getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(1);
  vname = ((HTMLObjectElement) /*Node */testNode).getName();
  assertEquals("OBJECT2", vname, "vspaceLink");
 }
}