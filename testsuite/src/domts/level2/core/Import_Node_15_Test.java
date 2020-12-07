package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should import the given importedNode into that Document.
* The importedNode is of type Text.
* 
* Create a text node with value being the string "this is text data" in 
* a different document.  Invoke method importNode(importedNode,deep) on
* this document.  Method should return a text node whose value matches
* the above string. The returned node should belong to this document 
* whose systemId is "staff.dtd"
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
@Disabled("2")
class Import_Node_15_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode15")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  Text text;
  Node aNode;
  Document ownerDocument;
  DocumentType docType;
  String system;
  String value;
  doc = (Document) load("staffNS", true);
  aNewDoc = (Document) load("staffNS", true);
  text = aNewDoc.createTextNode("this is text data");
  aNode = doc.importNode(text, false);
  ownerDocument = aNode.getOwnerDocument();
  assertNotNull(ownerDocument, "ownerDocumentNotNull");
  docType = ownerDocument.getDoctype();
  system = docType.getSystemId();
  assertTrue(equalsURI(null, null, null, "staffNS.dtd", null, null, null, null, system), "systemId");
  value = aNode.getNodeValue();
  assertEquals("this is text data", value, "nodeValue");
 }
}