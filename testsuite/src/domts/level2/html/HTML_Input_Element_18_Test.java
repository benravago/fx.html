package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The value attribute is the current content of the corresponding form 
* control when the type attribute has the value Text, File or Password.
* Retrieve the value attribute of the 2nd INPUT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-49531485">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-49531485</a>
*/
class HTML_Input_Element_18_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement18")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vvalue;
  Document doc;
  doc = (Document) load("input", false);
  nodeList = doc.getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(1);
  vvalue = ((HTMLInputElement) /*Node */testNode).getValue();
  assertEquals("ReHire", vvalue, "valueLink");
 }
}