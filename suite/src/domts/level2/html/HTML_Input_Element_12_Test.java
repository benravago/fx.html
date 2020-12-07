package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The readOnly attribute indicates that this control is read-only when
* type has a value of text or password only.
* Retrieve the readOnly attribute of the 1st INPUT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-88461592">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-88461592</a>
*/
class HTML_Input_Element_12_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "input", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLInputElement12")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vreadonly;
  Document doc;
  doc = (Document) load("input", false);
  nodeList = doc.getElementsByTagName("input");
  assertTrue(equalsSize(9, nodeList), "Asize");
  testNode = nodeList.item(0);
  vreadonly = ((HTMLInputElement) /*Node */testNode).getReadOnly();
  assertTrue(vreadonly, "readonlyLink");
 }
}