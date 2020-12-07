package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Attempting to add an new option using HTMLSelectElement.add before a node that is not a child of the select
* element should raise a NOT_FOUND_ERR.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-14493106">http://www.w3.org/TR/DOM-Level-2-HTML/html#ID-14493106</a>
*/
class HTML_Select_Element_20_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "select", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLSelectElement20")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Document doc;
  int optLength;
  int selected;
  Element newOpt;
  Text newOptText;
  Node retNode;
  HTMLCollection options;
  Element otherSelect;
  Node selectedNode;
  doc = (Document) load("select", true);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(3, nodeList), "Asize");
  testNode = nodeList.item(0);
  otherSelect = (Element) nodeList.item(1);
  newOpt = doc.createElement("option");
  newOptText = doc.createTextNode("EMP31415");
  retNode = newOpt.appendChild(newOptText);
  options = (HTMLCollection) ((HTMLSelectElement) /*Node */otherSelect).getOptions();
  selectedNode = options.item(0);
  {
   boolean success = false;
   try {
    ((HTMLSelectElement) /*Node */testNode).add(((HTMLElement) /*Node */newOpt), ((HTMLElement) /*Node */selectedNode));
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NOT_FOUND_ERR);
   }
   assertTrue(success, "throw_NOT_FOUND_ERR");
  }
 }
}