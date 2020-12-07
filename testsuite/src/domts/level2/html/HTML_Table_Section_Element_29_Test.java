package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The deleteRow() method throws a INDEX_SIZE_ERR DOMException
* if the specified index is negative.
* 
* Retrieve the first THEAD element which has one row.  Try
* to delete a row using an index of negative two.  This should throw
* a INDEX_SIZE_ERR DOMException since the index is negative.       
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-5625626">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-5625626</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#xpointer(id('ID-5625626')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])">http://www.w3.org/TR/DOM-Level-2-HTML/html#xpointer(id('ID-5625626')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])</a>
*/
class HTML_Table_Section_Element_29_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablesection", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableSectionElement29")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Document doc;
  doc = (Document) load("tablesection", true);
  nodeList = doc.getElementsByTagName("thead");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  {
   boolean success = false;
   try {
    ((HTMLTableSectionElement) /*Node */testNode).deleteRow(-2);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INDEX_SIZE_ERR);
   }
   assertTrue(success, "HTMLTableSectionElement29");
  }
 }
}