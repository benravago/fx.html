package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The text attribute specifies the script content of the element. 
* Retrieve the text attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-46872999">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-46872999</a>
*/
class HTML_Script_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "script", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLScriptElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vtext;
  Document doc;
  doc = (Document) load("script", false);
  nodeList = doc.getElementsByTagName("script");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vtext = ((HTMLScriptElement) /*Node */testNode).getText();
  assertEquals("var a=2;", vtext, "textLink");
 }
}