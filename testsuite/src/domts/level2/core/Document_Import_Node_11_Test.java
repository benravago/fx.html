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
* Using the method importNode with deep=false, import this Document's documentElement
* node.  Verify if the node has been imported correctly by its nodeName atttribute and
* if the original document is not altered by checking if hasChildNodes returns false.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Document_Import_Node_11_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentimportnode11")
 void run() throws Throwable {
  Document doc;
  Element docElement;
  Node imported;
  boolean success;
  String nodeNameOrig;
  String nodeNameImported;
  doc = (Document) load("staffNS", true);
  docElement = doc.getDocumentElement();
  imported = doc.importNode(docElement, false);
  success = imported.hasChildNodes();
  assertFalse(success, "documentimportnode11");
  nodeNameImported = imported.getNodeName();
  nodeNameOrig = docElement.getNodeName();
  assertEquals(nodeNameImported, nodeNameOrig, "documentimportnode11_NodeName");
 }
}