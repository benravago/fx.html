package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The caption attribute returns the tables CAPTION or void if it does not
* exist.
* Retrieve the CAPTION element from within the first TABLE element.  
* Since one does not exist it should be void.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-14594520">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-14594520</a>
*/
class HTML_Table_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLTableCaptionElement vcaption;
  Document doc;
  doc = (Document) load("table", false);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcaption = ((HTMLTableElement) /*Node */testNode).getCaption();
  assertNull(vcaption, "captionLink");
 }
}