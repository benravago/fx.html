package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The standby attribute specifies a message to render while loading the    
* object.
* Retrieve the standby attribute of the first OBJECT element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-25039673">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-25039673</a>
*/
class HTML_Object_Element_12_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "object", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLObjectElement12")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vstandby;
  Document doc;
  doc = (Document) load("object", false);
  nodeList = doc.getElementsByTagName("object");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vstandby = ((HTMLObjectElement) /*Node */testNode).getStandby();
  assertEquals("Loading Image ...", vstandby, "alignLink");
 }
}