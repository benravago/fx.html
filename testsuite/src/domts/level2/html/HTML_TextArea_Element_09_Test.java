package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The rows attribute specifies the number of text rowns.
* Retrieve the rows attribute of the 1st TEXTAREA element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-46975887">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-46975887</a>
*/
class HTML_TextArea_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "textarea", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTextAreaElement09")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vrows;
  Document doc;
  doc = (Document) load("textarea", false);
  nodeList = doc.getElementsByTagName("textarea");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  vrows = (int) ((HTMLTextAreaElement) /*Node */testNode).getRows();
  assertEquals(7, vrows, "rowsLink");
 }
}