package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The headers attribute specifies a list of id attribute values for          
* table header cells(TH).
* Retrieve the headers attribute from the second TH element and examine
* its value. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-89104817">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-89104817</a>
*/
class HTML_Table_Cell_Element_17_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecell", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableCellElement17")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vheaders;
  Document doc;
  doc = (Document) load("tablecell", false);
  nodeList = doc.getElementsByTagName("th");
  assertTrue(equalsSize(4, nodeList), "Asize");
  testNode = nodeList.item(1);
  vheaders = ((HTMLTableCellElement) /*Node */testNode).getHeaders();
  assertEquals("header-1", vheaders, "headersLink");
 }
}