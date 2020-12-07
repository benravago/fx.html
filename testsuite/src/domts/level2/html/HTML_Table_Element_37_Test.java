package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The deleteRow() method throws a INDEX_SIZE_ERR DOMException
* if the specified index is equal the number of rows. 
* 
* Retrieve the second TABLE element which has four rows.  Try
* to delete a new row using an index of four.  This should throw
* a INDEX_SIZE_ERR DOMException since the index is equal to the
* number of rows.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-13114938">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-13114938</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#xpointer(id('ID-13114938')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])">http://www.w3.org/TR/DOM-Level-2-HTML/html#xpointer(id('ID-13114938')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])</a>
*/
class HTML_Table_Element_37_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "table", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableElement37")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Document doc;
  doc = (Document) load("table", true);
  nodeList = doc.getElementsByTagName("table");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(1);
  {
   boolean success = false;
   try {
    ((HTMLTableElement) /*Node */testNode).deleteRow(4);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INDEX_SIZE_ERR);
   }
   assertTrue(success, "HTMLTableElement37");
  }
 }
}