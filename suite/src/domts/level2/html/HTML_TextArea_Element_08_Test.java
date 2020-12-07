package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The readOnly attribute specifies this control is read-only.
* Retrieve the readOnly attribute from the 3rd TEXTAREA element and
* examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39131423">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39131423</a>
*/
class HTML_TextArea_Element_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "textarea", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTextAreaElement08")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vreadonly;
  Document doc;
  doc = (Document) load("textarea", false);
  nodeList = doc.getElementsByTagName("textarea");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(2);
  vreadonly = ((HTMLTextAreaElement) /*Node */testNode).getReadOnly();
  assertTrue(vreadonly, "readOnlyLink");
 }
}