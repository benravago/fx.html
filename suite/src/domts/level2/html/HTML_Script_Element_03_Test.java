package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The defer attribute specifies the user agent can defer processing of
* the script.
* Retrieve the defer attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-93788534">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-93788534</a>
*/
class HTML_Script_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "script", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLScriptElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vdefer;
  Document doc;
  doc = (Document) load("script", false);
  nodeList = doc.getElementsByTagName("script");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vdefer = ((HTMLScriptElement) /*Node */testNode).getDefer();
  assertTrue(vdefer, "deferLink");
 }
}