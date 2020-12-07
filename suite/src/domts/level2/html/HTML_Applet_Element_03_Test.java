package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The archive attribute specifies a comma-seperated archive list. 
* Retrieve the archive attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-14476360">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-14476360</a>
*/
class HTML_Applet_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "applet", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAppletElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String varchive;
  Document doc;
  doc = (Document) load("applet", false);
  nodeList = doc.getElementsByTagName("applet");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  varchive = ((HTMLAppletElement) /*Node */testNode).getArchive();
  assertEquals("", varchive, "archiveLink");
 }
}