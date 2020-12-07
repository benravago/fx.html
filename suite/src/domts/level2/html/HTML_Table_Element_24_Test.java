package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The deleteTFoot() method deletes the footer from the table. 
* The deleteTFoot() method will delete the TFOOT Element from the
* second TABLE element.  First make sure that the TFOOT element exists
* and then count the number of rows.  After the TFOOT element is
* deleted there should be one less row.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-78363258">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-78363258</a>
*/
class HTML_Table_Element_24_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement24")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection rowsnodeList;
  Node testNode;
  HTMLTableElement vsection1;
  HTMLTableElement vsection2;
  int vrows;
  Document doc;
  List result = new ArrayList();
  List expectedResult = new ArrayList();
  expectedResult.add(new Integer(4));
  expectedResult.add(new Integer(3));
  doc = (Document) load("table", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  vsection1 = (HTMLTableElement) ((HTMLTableElement) /*Node */testNode).getTFoot();
  assertNotNull(vsection1, "vsection1Id");
  rowsnodeList = ((HTMLTableElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  result.add(new Integer(vrows));
  ((HTMLTableElement) /*Node */testNode).deleteTFoot();
  vsection2 = (HTMLTableElement) ((HTMLTableElement) /*Node */testNode).getTFoot();
  rowsnodeList = ((HTMLTableElement) /*Node */testNode).getRows();
  vrows = (int) rowsnodeList.getLength();
  result.add(new Integer(vrows));
  assertEquals(expectedResult, result, "rowsLink");
 }
}