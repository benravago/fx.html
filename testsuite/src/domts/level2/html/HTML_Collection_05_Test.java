package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The length attribute specifies the length or size of the list.
* Retrieve the first TABLE element and create a HTMLCollection by invoking
* the "rows" attribute.  Retrieve the length attribute of the HTMLCollection
* object.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-40057551">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-40057551</a>
*/
class HTML_Collection_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "collection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLCollection05")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLCollection rowsnodeList;
  int rowLength;
  Document doc;
  doc = (Document) load("collection", false);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  rowsnodeList = ((HTMLTableElement) /*Node */testNode).getRows();
  rowLength = (int) rowsnodeList.getLength();
  assertEquals(4, rowLength, "rowIndexLink");
 }
}