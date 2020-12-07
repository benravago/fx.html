package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should import the given importedNode into that Document.
* The importedNode is of type Element.
* If this document defines default attributes for this element name (importedNode),
* those default attributes are assigned.
* 
* Create an element whose name is "emp:employee" in a different document.
* Invoke method importNode(importedNode,deep) on this document which
* defines default attribute for the element name "emp:employee".
* Method should return an the imported element with an assigned default attribute.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=238">http://www.w3.org/Bugs/Public/show_bug.cgi?id=238</a>
*/
class Import_Node_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode07")
 void run() throws Throwable {
  Document doc;
  Document aNewDoc;
  Element element;
  Node aNode;
  NamedNodeMap attributes;
  String name;
  Node attr;
  String lname;
  String namespaceURI = "http://www.nist.gov";
  String qualifiedName = "emp:employee";
  doc = (Document) load("staffNS", true);
  aNewDoc = (Document) load("staff", true);
  element = aNewDoc.createElementNS(namespaceURI, qualifiedName);
  aNode = doc.importNode(element, false);
  attributes = aNode.getAttributes();
  assertTrue(equalsSize(1, attributes), "throw_Size");
  name = aNode.getNodeName();
  assertEquals("emp:employee", name, "nodeName");
  attr = attributes.item(0);
  lname = attr.getLocalName();
  assertEquals("defaultAttr", lname, "lname");
 }
}