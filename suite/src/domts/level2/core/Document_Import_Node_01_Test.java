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
* Using the method importNode with deep=true, import the attribute, "street" of the second 
* element node, from a list of nodes whose local names are "address" and namespaceURI 
* "http://www.nist.gov" into the same document.  Check the parentNode, nodeName, 
* nodeType and nodeValue of the imported node to verify if it has been imported correctly.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Document_Import_Node_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode01")
 void run() throws Throwable {
  Document doc;
  Element element;
  Attr attr;
  NodeList childList;
  Node importedAttr;
  String nodeName;
  int nodeType;
  String nodeValue;
  doc = (Document) load("staffNS", true);
  childList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
  element = (Element) childList.item(1);
  attr = element.getAttributeNode("street");
  importedAttr = doc.importNode(attr, false);
  nodeName = importedAttr.getNodeName();
  nodeValue = importedAttr.getNodeValue();
  nodeType = (int) importedAttr.getNodeType();
  assertEquals("street", nodeName, "documentimportnode01_nodeName");
  assertEquals(2, nodeType, "documentimportnode01_nodeType");
  assertEquals("Yes", nodeValue, "documentimportnode01_nodeValue");
 }
}