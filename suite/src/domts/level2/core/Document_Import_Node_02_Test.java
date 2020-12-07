package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The importNode method imports a node from another document to this document. 
* The returned node has no parent; (parentNode is null). The source node is not 
* altered or removed from the original document but a new copy of the source node
* is created.
* 
* Using the method importNode with deep=false, import the attribute, "emp:zone" of the 
* element node which is retreived by its elementId="CANADA", into the another document.
* Check the parentNode, nodeName, nodeType and nodeValue of the imported node to 
* verify if it has been imported correctly.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Document_Import_Node_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode02")
 void run() throws Throwable {
  Document doc;
  Document docImported;
  Element element;
  Attr attr;
  Node importedAttr;
  String nodeName;
  int nodeType;
  String nodeValue;
  NodeList addresses;
  Node attrsParent;
  doc = (Document) load("staffNS", true);
  docImported = (Document) load("staff", true);
  addresses = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
  element = (Element) addresses.item(1);
  attr = element.getAttributeNodeNS("http://www.nist.gov", "zone");
  importedAttr = docImported.importNode(attr, false);
  nodeName = importedAttr.getNodeName();
  nodeType = (int) importedAttr.getNodeType();
  nodeValue = importedAttr.getNodeValue();
  attrsParent = importedAttr.getParentNode();
  assertNull(attrsParent, "documentimportnode02_parentNull");
  assertEquals("emp:zone", nodeName, "documentimportnode02_nodeName");
  assertEquals(2, nodeType, "documentimportnode02_nodeType");
  assertEquals("CANADA", nodeValue, "documentimportnode02_nodeValue");
 }
}