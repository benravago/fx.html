package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method hasAttributes returns whether this node (if it is an element) has any attributes.
* Create a new Document, Element and Attr node.  Add the Attr to the Element and append the 
* Element to the Document.  Retreive the newly created element node from the document and check
* if it has attributes using hasAttributes.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs</a>
*/
class Node_Has_Attributes_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodehasattributes04")
 void run() throws Throwable {
  Document doc;
  Document newDoc;
  DocumentType docType = null;
  DOMImplementation domImpl;
  Element element;
  Element elementTest;
  Element elementDoc;
  Attr attribute;
  Node setNode;
  Node appendedChild;
  NodeList elementList;
  boolean hasAttributes;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  newDoc = domImpl.createDocument("http://www.w3.org/DOM/Test", "test", docType);
  element = newDoc.createElementNS("http://www.w3.org/DOM/Test", "dom:elem");
  attribute = newDoc.createAttribute("attr");
  setNode = element.setAttributeNode(attribute);
  elementDoc = newDoc.getDocumentElement();
  appendedChild = elementDoc.appendChild(element);
  elementList = newDoc.getElementsByTagNameNS("http://www.w3.org/DOM/Test", "elem");
  elementTest = (Element) elementList.item(0);
  hasAttributes = elementTest.hasAttributes();
  assertTrue(hasAttributes, "nodehasattributes04");
 }
}