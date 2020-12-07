package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method createAttributeNS creates an attribute of the given qualified name and namespace URI
* 
* Invoke the createAttributeNS method on this Document object with a valid values for 
* namespaceURI, and a qualifiedName as below.  This should return a valid Attr node.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS</a>
*/
class Document_Create_Attribute_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentcreateattributeNS02")
 void run() throws Throwable {
  Document doc;
  Attr attribute1;
  Attr attribute2;
  String name;
  String nodeName;
  String nodeValue;
  String prefix;
  String namespaceURI;
  doc = (Document) load("staffNS", false);
  attribute1 = doc.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:xml");
  name = attribute1.getName();
  nodeName = attribute1.getNodeName();
  nodeValue = attribute1.getNodeValue();
  prefix = attribute1.getPrefix();
  namespaceURI = attribute1.getNamespaceURI();
  assertEquals("xml:xml", name, "documentcreateattributeNS02_att1_name");
  assertEquals("xml:xml", nodeName, "documentcreateattributeNS02_att1_nodeName");
  assertEquals("", nodeValue, "documentcreateattributeNS02_att1_nodeValue");
  assertEquals("xml", prefix, "documentcreateattributeNS02_att1_prefix");
  assertEquals("http://www.w3.org/XML/1998/namespace", namespaceURI, "documentcreateattributeNS02_att1_namespaceURI");
  attribute2 = doc.createAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns");
  name = attribute2.getName();
  nodeName = attribute2.getNodeName();
  nodeValue = attribute2.getNodeValue();
  prefix = attribute2.getPrefix();
  namespaceURI = attribute2.getNamespaceURI();
  assertEquals("xmlns", name, "documentcreateattributeNS02_att2_name");
  assertEquals("xmlns", nodeName, "documentcreateattributeNS02_att2_nodeName");
  assertEquals("", nodeValue, "documentcreateattributeNS02_att2_nodeValue");
  assertEquals("http://www.w3.org/2000/xmlns/", namespaceURI, "documentcreateattributeNS02_att2_namespaceURI");
 }
}