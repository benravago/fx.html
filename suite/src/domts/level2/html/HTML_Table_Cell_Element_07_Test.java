package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The axis attribute specifies the names group of related headers for table
* header cells(TH).
* Retrieve the align attribute from the second TH element and examine
* its value. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-76554418">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-76554418</a>
*/
class HTML_Table_Cell_Element_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecell", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableCellElement07")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vaxis;
  Document doc;
  doc = (Document) load("tablecell", false);
  nodeList = doc.getElementsByTagName("th");
  assertTrue(equalsSize(4, nodeList), "Asize");
  testNode = nodeList.item(1);
  vaxis = ((HTMLTableCellElement) /*Node */testNode).getAxis();
  assertEquals("center", vaxis, "axisLink");
 }
}