package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should import the given importedNode into that Document.
* The importedNode is of type Attr. 
* The ownerElement is set to null. Specified flag is set to true.
* Children is imported.
* 
* Create a new attribute whose name is "elem:attr1" in a different document.
* Create a child Text node with value "importedText" for the attribute node above.
* Invoke method importNode(importedNode,deep) on this document with
* importedNode being the newly created attribute.
* Method should return a node whose name matches "elem:attr1" and a child node
* whose value equals "importedText".
* The returned node should belong to this document whose systemId is "staff.dtd"
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
@Disabled("2")
class Import_Node_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode01")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  Attr newAttr;
  Text importedChild;
  Node aNode;
  Document ownerDocument;
  Element attrOwnerElement;
  DocumentType docType;
  String system;
  boolean specified;
  NodeList childList;
  String nodeName;
  Node child;
  String childValue;
  List result = new ArrayList();
  List expectedResult = new ArrayList();
  expectedResult.add("elem:attr1");
  expectedResult.add("importedText");
  doc = (Document) load("staffNS", true);
  aNewDoc = (Document) load("staffNS", true);
  newAttr = aNewDoc.createAttribute("elem:attr1");
  importedChild = aNewDoc.createTextNode("importedText");
  aNode = newAttr.appendChild(importedChild);
  aNode = doc.importNode(newAttr, false);
  ownerDocument = aNode.getOwnerDocument();
  docType = ownerDocument.getDoctype();
  system = docType.getSystemId();
  assertNotNull(aNode, "aNode");
  assertTrue(equalsURI(null, null, null, "staffNS.dtd", null, null, null, null, system), "systemId");
  attrOwnerElement = ((Attr) /*Node */aNode).getOwnerElement();
  assertNull(attrOwnerElement, "ownerElement");
  specified = ((Attr) /*Node */aNode).getSpecified();
  assertTrue(specified, "specified");
  childList = aNode.getChildNodes();
  assertTrue(equalsSize(1, childList), "childList");
  nodeName = aNode.getNodeName();
  assertEquals("elem:attr1", nodeName, "nodeName");
  child = aNode.getFirstChild();
  childValue = child.getNodeValue();
  assertEquals("importedText", childValue, "childValue");
 }
}