package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* HTMLCollections are live, they are automatically updated when the     
* underlying document is changed.
* Create a HTMLCollection object by invoking the rows attribute of the    
* first TABLE element and examine its length, then add a new row and
* re-examine the length.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-40057551">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-40057551</a>
*/
class HTML_Collection_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "collection", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLCollection04")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  int rowLength1;
  int rowLength2;
  HTMLCollection rowsnodeList;
  HTMLElement newRow;
  int vrowindex;
  Document doc;
  List result = new ArrayList();
  List expectedResult = new ArrayList();
  expectedResult.add(new Integer(4));
  expectedResult.add(new Integer(5));
  doc = (Document) load("collection", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  rowsnodeList = ((HTMLTableElement) /*Node */testNode).getRows();
  rowLength1 = (int) rowsnodeList.getLength();
  result.add(new Integer(rowLength1));
  newRow = ((HTMLTableElement) /*Node */testNode).insertRow(4);
  rowLength2 = (int) rowsnodeList.getLength();
  result.add(new Integer(rowLength2));
  assertEquals(expectedResult, result, "rowIndexLink");
 }
}