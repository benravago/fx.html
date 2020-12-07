package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The insertRow() method inserts a new empty table row.  In addition, when
* the table is empty the row is inserted into a TBODY which is created
* and inserted into the table.
* 
* Load the table1 file which has a non-empty table element.
* Create an empty TABLE element and append to the document.
* Check to make sure that the empty TABLE element doesn't
* have a TBODY element.  Insert a new row into the empty
* TABLE element.  Check for existence of the a TBODY element
* in the table.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39872903">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-39872903</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2002Aug/0019.html">http://lists.w3.org/Archives/Public/www-dom-ts/2002Aug/0019.html</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=502">http://www.w3.org/Bugs/Public/show_bug.cgi?id=502</a>
*/
class HTML_Table_Element_31_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table1", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement31")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Node tableNode;
  HTMLCollection tbodiesnodeList;
  HTMLElement newRow;
  Document doc;
  Element table;
  int tbodiesLength;
  doc = (Document) load("table1", true);
  nodeList = doc.getElementsByTagName("body");
  assertTrue(equalsSize(1, nodeList), "tableSize1");
  testNode = nodeList.item(0);
  table = doc.createElement("table");
  tableNode = testNode.appendChild(table);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(2, nodeList), "tableSize2");
  tbodiesnodeList = ((HTMLTableElement) /*Node */tableNode).getTBodies();
  tbodiesLength = (int) tbodiesnodeList.getLength();
  assertEquals(0, tbodiesLength, "Asize3");
  newRow = ((HTMLTableElement) /*Node */tableNode).insertRow(0);
  tbodiesnodeList = ((HTMLTableElement) /*Node */tableNode).getTBodies();
  tbodiesLength = (int) tbodiesnodeList.getLength();
  assertEquals(1, tbodiesLength, "Asize4");
 }
}