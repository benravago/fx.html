package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The rows attribute returns a collection of all the rows in the table,
* including al in THEAD, TFOOT, all TBODY elements.
* Retrieve the rows attribute from the second TABLE element and
* examine the items of the returned collection. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-6156016">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-6156016</a>
*/
class HTML_Table_Element_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement07")
 void run() throws Throwable {
  NodeList nodeList;
  HTMLCollection rowsnodeList;
  Node testNode;
  Document doc;
  String rowName;
  Node vrow;
  List result = new ArrayList();
  List expectedOptions = new ArrayList();
  expectedOptions.add("tr");
  expectedOptions.add("tr");
  expectedOptions.add("tr");
  expectedOptions.add("tr");
  doc = (Document) load("table", false);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  rowsnodeList = ((HTMLTableElement) /*Node */testNode).getRows();
  for (int indexN10069 = 0; indexN10069 < rowsnodeList.getLength(); indexN10069++) {
   vrow = (Node) rowsnodeList.item(indexN10069);
   rowName = vrow.getNodeName();
   result.add(rowName);
  }
  assertTrue(equalsAutoCase("element", expectedOptions, result), "rowsLink");
 }
}