package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The noWrap attribute supresses word wrapping.                    
* Retrieve the noWrap attribute of the second TH Element and
* examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-62922045">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-62922045</a>
*/
class HTML_Table_Cell_Element_21_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablecell", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableCellElement21")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  boolean vnowrap;
  Document doc;
  doc = (Document) load("tablecell", false);
  nodeList = doc.getElementsByTagName("th");
  assertTrue(equalsSize(4, nodeList), "Asize");
  testNode = nodeList.item(1);
  vnowrap = ((HTMLTableCellElement) /*Node */testNode).getNoWrap();
  assertTrue(vnowrap, "noWrapLink");
 }
}