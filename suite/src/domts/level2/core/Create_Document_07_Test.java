package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createDocument(namespaceURI,qualifiedName,doctype)" method for a 
* DOMImplementation should return a new xml Document object of the 
* specified type with its document element given that all parameters are
* valid and correctly formed.
* 
* Invoke method createDocument(namespaceURI,qualifiedName,doctype) on
* this domimplementation. namespaceURI is "http://www.ecommerce.org/schema"
* qualifiedName is "y:x" and doctype is null.
* Method should return a new xml Document as specified by the listed parameters.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocument</a>
*/
class Create_Document_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createDocument07")
 void run() throws Throwable {
  String namespaceURI = "http://www.ecommerce.org/schema";
  String qualifiedName = "y:x";
  Document doc;
  DocumentType docType = null;
  DOMImplementation domImpl;
  Document aNewDoc;
  String nodeName;
  String nodeValue;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  aNewDoc = domImpl.createDocument(namespaceURI, qualifiedName, docType);
  nodeName = aNewDoc.getNodeName();
  nodeValue = aNewDoc.getNodeValue();
  assertEquals("#document", nodeName, "nodeName");
  assertNull(nodeValue, "nodeValue");
 }
}