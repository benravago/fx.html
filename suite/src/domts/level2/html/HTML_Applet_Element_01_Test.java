package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The align attribute specifies the alignment of the object(Vertically
* or Horizontally) with respect to its surrounding text.
* Retrieve the align attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-8049912">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-8049912</a>
*/
class HTML_Applet_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "applet", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAppletElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String valign;
  Document doc;
  doc = (Document) load("applet", false);
  nodeList = doc.getElementsByTagName("applet");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  valign = ((HTMLAppletElement) /*Node */testNode).getAlign();
  assertTrue(equalsIgnoreCase("bottom", valign), "alignLink");
 }
}