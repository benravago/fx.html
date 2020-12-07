package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The code attribute specifies an Applet class file.
* Retrieve the code attribute of the second OBJECT element and examine
* its value.  Should be "" since CODE is not a valid attribute for OBJECT.     
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-75241146">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-75241146</a>
*/
class HTML_Object_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLObjectElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcode;
  Document doc;
  doc = (Document) load("object", false);
  nodeList = doc.getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(1);
  vcode = ((HTMLObjectElement) /*Node */testNode).getCode();
  assertEquals("", vcode, "codeLink");
 }
}