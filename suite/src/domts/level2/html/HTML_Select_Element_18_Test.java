package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Add a new option at the end of an select using HTMLSelectElement.add.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-14493106">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-14493106</a>
*/
class HTML_Select_Element_18_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "select", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLSelectElement18")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Document doc;
  int optLength;
  int selected;
  Element newOpt;
  Text newOptText;
  Element opt;
  Text optText;
  String optValue;
  Node retNode;
  Node nullNode = null;
  doc = (Document) load("select", true);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  newOpt = doc.createElement("option");
  newOptText = doc.createTextNode("EMP31415");
  retNode = newOpt.appendChild(newOptText);
  ((HTMLSelectElement) /*Node */testNode).add(((HTMLElement) /*Node */newOpt), ((HTMLElement) /*Node */nullNode));
  optLength = (int) ((HTMLSelectElement) /*Node */testNode).getLength();
  assertEquals(6, optLength, "optLength");
  selected = (int) ((HTMLSelectElement) /*Node */testNode).getSelectedIndex();
  assertEquals(0, selected, "selected");
  opt = (Element) testNode.getLastChild();
  optText = (Text) opt.getFirstChild();
  optValue = optText.getNodeValue();
  assertEquals("EMP31415", optValue, "lastValue");
 }
}