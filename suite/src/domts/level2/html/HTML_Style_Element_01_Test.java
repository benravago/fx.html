package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The disabled attribute enables/disables the stylesheet.            
* Retrieve the disabled attribute and examine its value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-51162010">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-51162010</a>
*/
class HTML_Style_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "style", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLStyleElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vdisabled;
  Document doc;
  doc = (Document) load("style", false);
  nodeList = doc.getElementsByTagName("style");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vdisabled = ((HTMLStyleElement) /*Node */testNode).getDisabled();
  assertFalse(vdisabled, "disabledLink");
 }
}