package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The compact attribute specifies a boolean value on whether to display
* the list more compactly. 
* Retrieve the compact attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-75317739">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-75317739</a>
*/
class HTML_Directory_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "directory", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLDirectoryElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vcompact;
  Document doc;
  doc = (Document) load("directory", false);
  nodeList = doc.getElementsByTagName("dir");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcompact = ((HTMLDirectoryElement) /*Node */testNode).getCompact();
  assertTrue(vcompact, "compactLink");
 }
}