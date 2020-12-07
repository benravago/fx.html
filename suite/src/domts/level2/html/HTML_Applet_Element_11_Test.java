package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The object attribute specifies the serialized applet file.
* Retrieve the object attribute and examine its value.  
* @author NIST
* @author Rick Rivello
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-93681523">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-93681523</a>
*/
class HTML_Applet_Element_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "applet2", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAppletElement11")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vobject;
  Document doc;
  doc = (Document) load("applet2", false);
  nodeList = doc.getElementsByTagName("applet");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vobject = ((HTMLAppletElement) /*Node */testNode).getObject();
  assertEquals("DOMTSApplet.dat", vobject, "object");
 }
}