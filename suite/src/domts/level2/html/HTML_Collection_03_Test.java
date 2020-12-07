package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* An individual node may be accessed by either ordinal index, the node's
* name or id attributes.  (Test id attribute).
* Retrieve the first FORM element and create a HTMLCollection by invoking
* the "element" attribute.  The first SELECT element is further retrieved 
* using the elements id.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-21069976">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-21069976</a>
*/
class HTML_Collection_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "collection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLCollection03")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Node formNode;
  HTMLCollection formsnodeList;
  String vname;
  Document doc;
  doc = (Document) load("collection", false);
  nodeList = doc.getElementsByTagName("form");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  formsnodeList = ((HTMLFormElement) /*Node */testNode).getElements();
  formNode = formsnodeList.namedItem("selectId");
  vname = formNode.getNodeName();
  assertTrue(equalsAutoCase("element", "select", vname), "nameIndexLink");
 }
}