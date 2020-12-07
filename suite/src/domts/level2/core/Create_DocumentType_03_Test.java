package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createDocumentType(qualifiedName,publicId,systemId)" method for a 
* DOMImplementation should return a new DocumentType node 
* given that qualifiedName is valid and correctly formed.
* 
* Invoke method createDocumentType(qualifiedName,publicId,systemId) on
* this domimplementation with qualifiedName "prefix:myDoc".
* Method should return a new DocumentType node.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType</a>
*/
class Create_DocumentType_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createDocumentType03")
 void run() throws Throwable {
  String namespaceURI = "http://ecommerce.org/schema";
  String qualifiedName = "prefix:myDoc";
  String publicId = "http://www.localhost.com";
  String systemId = "myDoc.dtd";
  Document doc;
  DOMImplementation domImpl;
  DocumentType newType = null;
  String nodeName;
  String nodeValue;
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  newType = domImpl.createDocumentType(qualifiedName, publicId, systemId);
  nodeName = newType.getNodeName();
  assertEquals("prefix:myDoc", nodeName, "nodeName");
  nodeValue = newType.getNodeValue();
  assertNull(nodeValue, "nodeValue");
 }
}