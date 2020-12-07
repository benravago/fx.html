package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The coords attribute specifies a comma-seperated list of lengths, 
* defining an active region geometry.
* Retrieve the coords attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-66021476">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-66021476</a>
*/
class HTML_Area_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "area", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLAreaElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcoords;
  Document doc;
  doc = (Document) load("area", false);
  nodeList = doc.getElementsByTagName("area");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  vcoords = ((HTMLAreaElement) /*Node */testNode).getCoords();
  assertEquals("0,2,45,45", vcoords, "coordsLink");
 }
}