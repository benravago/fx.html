package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The insertCell() method throws a INDEX_SIZE_ERR DOMException
* if the specified index is negative. 
* 
* Retrieve the fourth TR element which has six cells.  Try
* to insert a cell using an index of negative seven.  This should throw
* a INDEX_SIZE_ERR DOMException since the index is negative.   
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-68927016">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-68927016</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#xpointer(id('ID-68927016')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])">http://www.w3.org/TR/DOM-Level-2-HTML/html#xpointer(id('ID-68927016')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])</a>
*/
class HTML_Table_Row_Element_16_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablerow", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableRowElement16")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  HTMLElement newCell;
  Document doc;
  doc = (Document) load("tablerow", true);
  nodeList = doc.getElementsByTagName("tr");
  assertTrue(equalsSize(5, nodeList), "Asize");
  testNode = nodeList.item(3);
  {
   boolean success = false;
   try {
    newCell = ((HTMLTableRowElement) /*Node */testNode).insertCell(-7);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INDEX_SIZE_ERR);
   }
   assertTrue(success, "HTMLTableRowElement16");
  }
 }
}