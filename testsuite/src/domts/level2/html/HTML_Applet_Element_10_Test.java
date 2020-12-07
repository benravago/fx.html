package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The width attribute overrides the regular width. 
* Retrieve the width attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-16526327">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-16526327</a>
*/
class HTML_Applet_Element_10_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "applet", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAppletElement10")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vwidth;
  Document doc;
  doc = (Document) load("applet", false);
  nodeList = doc.getElementsByTagName("applet");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vwidth = ((HTMLAppletElement) /*Node */testNode).getWidth();
  assertEquals("301", vwidth, "widthLink");
 }
}