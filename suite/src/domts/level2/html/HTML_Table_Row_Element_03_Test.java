package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The sectionRowIndex attribute specifies the index of this row, relative   
* to the current section(THEAD, TFOOT, or TBODY),starting from 0. 
* Retrieve the third TR(1st In TFOOT) element within the document and 
* examine its sectionRowIndex value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-79105901">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-79105901</a>
*/
class HTML_Table_Row_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablerow", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableRowElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int vsectionrowindex;
  Document doc;
  doc = (Document) load("tablerow", false);
  nodeList = doc.getElementsByTagName("tr");
  assertTrue(equalsSize(5, nodeList), "Asize");
  testNode = nodeList.item(2);
  vsectionrowindex = (int) ((HTMLTableRowElement) /*Node */testNode).getSectionRowIndex();
  assertEquals(0, vsectionrowindex, "sectionRowIndexLink");
 }
}