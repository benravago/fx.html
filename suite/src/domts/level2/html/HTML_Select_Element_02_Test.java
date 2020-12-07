package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The selectedIndex attribute specifies the ordinal index of the selected  
* option.
* Retrieve the selectedIndex attribute from the first SELECT element and 
* examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-85676760">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-85676760</a>
*/
class HTML_Select_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "select", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLSelectElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vselectedindex;
  Document doc;
  doc = (Document) load("select", false);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  vselectedindex = (int) ((HTMLSelectElement) /*Node */testNode).getSelectedIndex();
  assertEquals(0, vselectedindex, "selectedIndexLink");
 }
}