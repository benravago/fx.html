package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The align attribute specifies the caption alignment with respect to
* the table.
* Retrieve the align attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-79875068">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-79875068</a>
*/
class HTML_Table_Caption_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecaption", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableCaptionElement01")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String valign;
  Document doc;
  doc = (Document) load("tablecaption", false);
  nodeList = doc.getElementsByTagName("caption");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  valign = ((HTMLTableCaptionElement) /*Node */testNode).getAlign();
  assertEquals("top", valign, "alignLink");
 }
}