package domts.level2.html;
import org.w3c.dom.*;
import org.w3c.dom.html.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The namedItem(name) method retrieves a node using a name.  It first   
* searches for a node with a matching id attribute.  If it doesn't find
* one, it then searches for a Node with a matching name attribute, but only
* on those elements that are allowed a name attribute. If there isn't
* a matching node the method returns null.
* Retrieve the first FORM element and create a HTMLCollection by invoking
* the elements attribute.  The method returns null since there is not a 
* match of the name or id attribute.
* @author NIST
* @author Rick Rivello
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-21069976">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-21069976</a>
*/
class HTML_Collection_12_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "collection", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/html/HTMLCollection12")
 void run() throws Throwable {
  NodeList nodeList;
  Node testNode;
  Node formNode;
  HTMLCollection formsnodeList;
  Document doc;
  doc = (Document) load("collection", false);
  nodeList = doc.getElementsByTagName("form");
  assertTrue(equalsSize(1, nodeList), "Asize");
  testNode = nodeList.item(0);
  formsnodeList = ((HTMLFormElement) /*Node */testNode).getElements();
  formNode = formsnodeList.namedItem("select9");
  assertNull(formNode, "nameIndexLink");
 }
}