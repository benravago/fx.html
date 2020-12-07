package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The value attribute contains the current form control value. 
* Retrieve the value attribute from the first OPTION element
* and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-6185554">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-6185554</a>
*/
class HTML_Option_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "option", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLOptionElement09")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vvalue;
  Document doc;
  doc = (Document) load("option", false);
  nodeList = doc.getElementsByTagName("option");
  assertTrue(equalsSize(10, nodeList), "Asize");
  testNode = nodeList.item(0);
  vvalue = ((HTMLOptionElement) /*Node */testNode).getValue();
  assertEquals("10001", vvalue, "valueLink");
 }
}