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
* name or id attributes.  (Test node name).
* The namedItem method retrieves a Node using a name.  It first searches
* for a node with a matching id attribute.  If it doesn't find one, it
* then searches for a Node with a matching name attribute, but only
* those elements that are allowed a name attribute.
* Retrieve the first FORM element.  Create a HTMLCollection of the elements.
* Search for an element that has select1 as the value for the name attribute.
* Get the nodeName of that element.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/DOM-Level-2-HTML/html#HTMLOptionsCollection-namedItem">http://www.w3.org/TR/DOM-Level-2-HTML/html#HTMLOptionsCollection-namedItem</a>
*/
class HTML_Options_Collection_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "optionscollection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLOptionsCollection03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Node optionsNode;
  HTMLCollection formsnodeList;
  String vname;
  Document doc;
  doc = (Document) load("optionscollection", false);
  nodeList = doc.getElementsByTagName("form");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  formsnodeList = ((HTMLFormElement) /*Node */testNode).getElements();
  optionsNode = ((HTMLCollection) /*HTMLCollection */formsnodeList).namedItem("select1");
  vname = optionsNode.getNodeName();
  assertTrue(equalsAutoCase("element", "select", vname), "nameIndexLink");
 }
}