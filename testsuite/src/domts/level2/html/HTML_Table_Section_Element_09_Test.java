package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The chOff attribute specifies the offset of alignment character.
* Retrieve the charoff attribute of the first TBODY element and examine
* its value.  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-53459732">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-53459732</a>
*/
class HTML_Table_Section_Element_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "tablesection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLTableSectionElement09")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  String vcharoff;
  Document doc;
  doc = (Document) load("tablesection", false);
  nodeList = doc.getElementsByTagName("tbody");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(1);
  vcharoff = ((HTMLTableSectionElement) /*Node */testNode).getChOff();
  assertEquals("3", vcharoff, "chOffLink");
 }
}