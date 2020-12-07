package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The rows attribute specifies the collection of rows in this table section. 
* Retrieve the first TFOOT element and examine the value of
* the rows length attribute.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-52092650">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-52092650</a>
*/
class HTML_Table_Section_Element_14_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablesection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableSectionElement14")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection rowsnodeList;
  Node testNode;
  int vrows;
  Document doc;
  doc = (Document) load("tablesection", false);
  nodeList = doc.getElementsByTagName("tfoot");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  rowsnodeList = ((HTMLTableSectionElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  assertEquals(1, vrows, "rowsLink");
 }
}