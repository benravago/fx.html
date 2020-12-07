package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The vAlign attribute specifies the vertical alignment of data within 
* cells of this row.    
* Retrieve the vAlign attribute of the second TR element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-90000058">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-90000058</a>
*/
class HTML_Table_Row_Element_10_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablerow", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableRowElement10")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vvalign;
  Document doc;
  doc = (Document) load("tablerow", false);
  nodeList = doc.getElementsByTagName("tr");
  assertTrue(equalsSize(5, nodeList), "Asize");
  testNode = nodeList.item(1);
  vvalign = ((HTMLTableRowElement) /*Node */testNode).getVAlign();
  assertEquals("middle", vvalign, "vAlignLink");
 }
}