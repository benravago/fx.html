package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should import the given importedNode into that Document.
* The importedNode is of type Element.
* 
* Retrieve element "emp:address" from staffNS.xml document.
* Invoke method importNode(importedNode,deep) on this document
* with importedNode being the element from above and deep is true.
* Method should return an element node whose name matches "emp:address" and
* whose descendant is imported.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Import_Node_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode06")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  Element element;
  Node aNode;
  boolean hasChild;
  String name;
  Node child;
  String value;
  NodeList addresses;
  doc = (Document) load("staffNS", true);
  aNewDoc = (Document) load("staffNS", true);
  addresses = aNewDoc.getElementsByTagName("emp:address");
  element = (Element) addresses.item(0);
  assertNotNull(element, "empAddressNotNull");
  aNode = doc.importNode(element, true);
  hasChild = aNode.hasChildNodes();
  assertTrue(hasChild, "throw_True");
  name = aNode.getNodeName();
  assertEquals("emp:address", name, "nodeName");
  child = aNode.getFirstChild();
  value = child.getNodeValue();
  assertEquals("27 South Road. Dallas, texas 98556", value, "nodeValue");
 }
}