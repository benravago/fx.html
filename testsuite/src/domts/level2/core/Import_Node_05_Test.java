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
* with importedNode being the element from above and deep is false.
* Method should return an element node whose name matches "emp:address" 
* and whose children are not imported. The returned node should 
* belong to this document whose systemId is "staff.dtd"
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
@Disabled("2")
class Import_Node_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode05")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  Element element;
  Node aNode;
  boolean hasChild;
  Document ownerDocument;
  DocumentType docType;
  String system;
  String name;
  NodeList addresses;
  doc = (Document) load("staffNS", true);
  aNewDoc = (Document) load("staffNS", true);
  addresses = aNewDoc.getElementsByTagName("emp:address");
  element = (Element) addresses.item(0);
  assertNotNull(element, "empAddressNotNull");
  aNode = doc.importNode(element, false);
  hasChild = aNode.hasChildNodes();
  assertFalse(hasChild, "hasChild");
  ownerDocument = aNode.getOwnerDocument();
  docType = ownerDocument.getDoctype();
  system = docType.getSystemId();
  assertTrue(equalsURI(null, null, null, "staffNS.dtd", null, null, null, null, system), "dtdSystemId");
  name = aNode.getNodeName();
  assertEquals("emp:address", name, "nodeName");
 }
}