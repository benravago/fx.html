package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The label attribute specifies the label assigned to this option group.
* Retrieve the label attribute and examine its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-95806054">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-95806054</a>
*/
class HTML_OptGroup_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "optgroup", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLOptGroupElement02")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vlabel;
  Document doc;
  doc = (Document) load("optgroup", false);
  nodeList = doc.getElementsByTagName("optgroup");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  vlabel = ((HTMLOptGroupElement) /*Node */testNode).getLabel();
  assertEquals("Regular Employees", vlabel, "labelLink");
 }
}