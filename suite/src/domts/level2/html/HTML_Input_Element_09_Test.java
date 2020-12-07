package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The disabled attribute has a TRUE value if it is explicitly set.
* Retrieve the disabled attribute of the 7th INPUT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-50886781">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-50886781</a>
*/
class HTML_Input_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement09")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vdisabled;
  Document doc;
  doc = (Document) load("input", false);
  nodeList = doc.getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(6);
  vdisabled = ((HTMLInputElement) /*Node */testNode).getDisabled();
  assertTrue(vdisabled, "disabledLink");
 }
}