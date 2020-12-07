package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should import the given importedNode into that Document.
* The importedNode is of type Document_Fragment.
* 
* Create a DocumentFragment in a different document.
* Create a Comment child node for the Document Fragment.
* Invoke method importNode(importedNode,deep) on this document
* with importedNode being the newly created DocumentFragment.
* Method should return a node of type DocumentFragment whose child has
* comment value "descendant1".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
class Import_Node_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode04")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  DocumentFragment docFrag;
  Comment comment;
  Node aNode;
  NodeList children;
  Node child;
  String childValue;
  doc = (Document) load("staff", true);
  aNewDoc = (Document) load("staff", true);
  docFrag = aNewDoc.createDocumentFragment();
  comment = aNewDoc.createComment("descendant1");
  aNode = docFrag.appendChild(comment);
  aNode = doc.importNode(docFrag, true);
  children = aNode.getChildNodes();
  assertTrue(equalsSize(1, children), "throw_Size");
  child = aNode.getFirstChild();
  childValue = child.getNodeValue();
  assertEquals("descendant1", childValue, "descendant1");
 }
}