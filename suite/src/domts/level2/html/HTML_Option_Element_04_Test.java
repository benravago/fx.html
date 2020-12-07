package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The text attribute contains the text contained within the option element.
* Retrieve the text attribute from the second OPTION element
* and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-48154426">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-48154426</a>
*/
class HTML_Option_Element_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "option", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLOptionElement04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vtext;
  Document doc;
  doc = (Document) load("option", false);
  nodeList = doc.getElementsByTagName("option");
  assertTrue(equalsSize(10, nodeList), "Asize");
  testNode = nodeList.item(1);
  vtext = ((HTMLOptionElement) /*Node */testNode).getText();
  assertEquals("EMP10002", vtext, "textLink");
 }
}