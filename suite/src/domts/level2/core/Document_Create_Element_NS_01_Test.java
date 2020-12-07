package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method createElementNS creates an element of the given valid qualifiedName and NamespaceURI. 
* 
* Invoke the createElementNS method on this Document object with a valid namespaceURI
* and qualifiedName.  Check if a valid Element object is returned with the same node attributes.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrElNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrElNS</a>
*/
class Document_Create_Element_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentcreateelementNS01")
 void run() throws Throwable {
  Document doc;
  Element element;
  String namespaceURI = "http://www.w3.org/DOM/Test/level2";
  String qualifiedName = "XML:XML";
  String nodeName;
  String nsURI;
  String localName;
  String prefix;
  String tagName;
  doc = (Document) load("staffNS", false);
  element = doc.createElementNS(namespaceURI, qualifiedName);
  nodeName = element.getNodeName();
  nsURI = element.getNamespaceURI();
  localName = element.getLocalName();
  prefix = element.getPrefix();
  tagName = element.getTagName();
  assertEquals("XML:XML", nodeName, "documentcreateelementNS01_nodeName");
  assertEquals("http://www.w3.org/DOM/Test/level2", nsURI, "documentcreateelementNS01_namespaceURI");
  assertEquals("XML", localName, "documentcreateelementNS01_localName");
  assertEquals("XML", prefix, "documentcreateelementNS01_prefix");
  assertEquals("XML:XML", tagName, "documentcreateelementNS01_tagName");
 }
}