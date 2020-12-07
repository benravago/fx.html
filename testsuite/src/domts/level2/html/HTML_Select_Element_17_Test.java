package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Removes a non-existant option using HTMLSelectElement.remove.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-33404570">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-33404570</a>
*/
class HTML_Select_Element_17_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "select", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLSelectElement17")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Document doc;
  int optLength;
  int selected;
  doc = (Document) load("select", true);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  ((HTMLSelectElement) /*Node */testNode).remove(6);
  optLength = (int) ((HTMLSelectElement) /*Node */testNode).getLength();
  assertEquals(5, optLength, "optLength");
  selected = (int) ((HTMLSelectElement) /*Node */testNode).getSelectedIndex();
  assertEquals(0, selected, "selected");
 }
}