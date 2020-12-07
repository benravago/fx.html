package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should import the given importedNode into that Document.
* The importedNode is of type Processing Instruction.
* 
* Create a processing instruction with target as "target1" and data as "data1" 
* in a different document. Invoke method importNode(importedNode,deep) on this document.
* Method should return a processing instruction whose target and data match the given 
* parameters. The returned PI should belong to this document whose systemId is "staff.dtd".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
@Disabled("2")
class Import_Node_14_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode14")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  ProcessingInstruction pi;
  ProcessingInstruction aNode;
  Document ownerDocument;
  DocumentType docType;
  String system;
  String target;
  String data;
  List result = new ArrayList();
  doc = (Document) load("staffNS", true);
  aNewDoc = (Document) load("staffNS", true);
  pi = aNewDoc.createProcessingInstruction("target1", "data1");
  aNode = (ProcessingInstruction) doc.importNode(pi, false);
  ownerDocument = aNode.getOwnerDocument();
  assertNotNull(ownerDocument, "ownerDocumentNotNull");
  docType = ownerDocument.getDoctype();
  system = docType.getSystemId();
  assertTrue(equalsURI(null, null, null, "staffNS.dtd", null, null, null, null, system), "systemId");
  target = aNode.getTarget();
  assertEquals("target1", target, "piTarget");
  data = aNode.getData();
  assertEquals("data1", data, "piData");
 }
}