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
* Using the method importNode with deep=false, import a newly created attribute node, 
* into the another document.
* Check the nodeName, nodeType and nodeValue namespaceURI of the imported node to 
* verify if it has been imported correctly.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Document_Import_Node_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode05")
 void run() throws Throwable {
  Document doc;
  Document docImported;
  Attr attr;
  Node importedAttr;
  String nodeName;
  int nodeType;
  String nodeValue;
  String namespaceURI;
  doc = (Document) load("staffNS", true);
  docImported = (Document) load("staff", true);
  attr = doc.createAttributeNS("http://www.w3.org/DOM/Test", "a_:b0");
  importedAttr = docImported.importNode(attr, false);
  nodeName = importedAttr.getNodeName();
  nodeValue = importedAttr.getNodeValue();
  nodeType = (int) importedAttr.getNodeType();
  namespaceURI = importedAttr.getNamespaceURI();
  assertEquals("a_:b0", nodeName, "documentimportnode05_nodeName");
  assertEquals(2, nodeType, "documentimportnode05_nodeType");
  assertEquals("", nodeValue, "documentimportnode05_nodeValue");
  assertEquals("http://www.w3.org/DOM/Test", namespaceURI, "documentimportnode05_namespaceURI");
 }
}