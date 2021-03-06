package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The abbr attribute specifies the abbreviation for table data cells(TD).
* Retrieve the abbr attribute from the second TD element and examine
* its value. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-74444037">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-74444037</a>
*/
class HTML_Table_Cell_Element_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecell", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableCellElement04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vabbr;
  Document doc;
  doc = (Document) load("tablecell", false);
  nodeList = doc.getElementsByTagName("td");
  assertTrue(equalsSize(4, nodeList), "Asize");
  testNode = nodeList.item(1);
  vabbr = ((HTMLTableCellElement) /*Node */testNode).getAbbr();
  assertEquals("hd2", vabbr, "abbrLink");
 }
}