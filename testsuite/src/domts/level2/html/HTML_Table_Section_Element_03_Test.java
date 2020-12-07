package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The align attribute specifies the horizontal alignment of data within 
* cells.    
* Retrieve the align attribute of the first TBODY element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-40530119">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-40530119</a>
*/
class HTML_Table_Section_Element_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablesection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableSectionElement03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String valign;
  Document doc;
  doc = (Document) load("tablesection", false);
  nodeList = doc.getElementsByTagName("tbody");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(1);
  valign = ((HTMLTableSectionElement) /*Node */testNode).getAlign();
  assertEquals("center", valign, "alignLink");
 }
}