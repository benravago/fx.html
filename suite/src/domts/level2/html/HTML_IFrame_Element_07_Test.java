package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The name attribute specifies the frame name(object of the target 
* attribute).    
* Retrieve the name attribute of the first IFRAME element and examine
* it's value.  
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96819659">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-96819659</a>
*/
class HTML_IFrame_Element_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "iframe", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLIFrameElement07")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vname;
  Document doc;
  doc = (Document) load("iframe", false);
  nodeList = doc.getElementsByTagName("iframe");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vname = ((HTMLIFrameElement) /*Node */testNode).getName();
  assertEquals("Iframe1", vname, "nameLink");
 }
}