package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The prompt attribute specifies the prompt message.
* Retrieve the prompt attribute of the 1st isindex element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-33589862">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-33589862</a>
*/
class HTML_Is_Index_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "isindex", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLIsIndexElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vprompt;
  Document doc;
  doc = (Document) load("isindex", false);
  nodeList = doc.getElementsByTagName("isindex");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vprompt = ((HTMLIsIndexElement) /*Node */testNode).getPrompt();
  assertEquals("New Employee: ", vprompt, "promptLink");
 }
}