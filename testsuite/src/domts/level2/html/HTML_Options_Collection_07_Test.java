package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* An HTMLOptionsCollection is a list of nodes representing HTML option
* element.
* An individual node may be accessed by either ordinal index, the node's
* name or id attributes.  (Test ordinal index=0).
* The item() method retrieves a node specified by ordinal index. Nodes
* are numbered in tree order.  The index origin is 0.
* Retrieve the first SELECT element.  Create a HTMLOptionsCollection.
* Retrieve the first item in the list and examine its firstChild's
* nodeValue. 
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#HTMLOptionsCollection-item">http://www.w3.org/TR/DOM-Level-2-HTML/html#HTMLOptionsCollection-item</a>
*/
class HTML_Options_Collection_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "optionscollection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLOptionsCollection07")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Node optionsNode;
  Node optionsValueNode;
  HTMLCollection optionsList;
  String vvalue;
  Document doc;
  doc = (Document) load("optionscollection", false);
  nodeList = doc.getElementsByTagName("select");
  assertTrue(equalsSize(2, nodeList), "Asize");
  testNode = nodeList.item(0);
  optionsList = ((HTMLSelectElement) /*Node */testNode).getOptions();
  optionsNode = optionsList.item(0);
  optionsValueNode = optionsNode.getFirstChild();
  vvalue = optionsValueNode.getNodeValue();
  assertEquals("EMP10001", vvalue, "valueIndexLink");
 }
}