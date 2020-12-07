package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The bgColor attribute specifies the background color of rows. 
* Retrieve the bgColor attribute of the second TR element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-18161327">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-18161327</a>
*/
class HTML_Table_Row_Element_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablerow", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableRowElement07")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vbgcolor;
  Document doc;
  doc = (Document) load("tablerow", false);
  nodeList = doc.getElementsByTagName("tr");
  assertTrue(equalsSize(5, nodeList), "Asize");
  testNode = nodeList.item(1);
  vbgcolor = ((HTMLTableRowElement) /*Node */testNode).getBgColor();
  assertTrue(equalsIgnoreCase("#00FFFF", vbgcolor), "bgColorLink");
 }
}