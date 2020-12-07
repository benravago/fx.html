package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNS(namespaceURI,qualifiedName,value)" method adds a new attribute.
* If an attribute with the same local name and namespace URI is already present
* on the element, its prefix is changed to be the prefix part of the "qualifiedName",
* and its vale is changed to be the "value" paramter.
* null value if no previously existing Attr node with the
* same name was replaced.
* 
* Add a new attribute to the "emp:address" element.
* Check to see if the new attribute has been successfully added to the document
* by getting the attributes value, namespace URI, local Name and prefix.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
*/
class Set_Attribute_NS_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setAttributeNS09")
 void run() throws Throwable {
  String localName = "newAttr";
  String namespaceURI = "http://www.newattr.com";
  String qualifiedName = "emp:newAttr";
  Document doc;
  NodeList elementList;
  Node testAddr;
  Attr addrAttr;
  String resultAttr;
  String resultNamespaceURI;
  String resultLocalName;
  String resultPrefix;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = elementList.item(0);
  assertNotNull(testAddr, "empAddrNotNull");
  ((Element) /*Node */testAddr).setAttributeNS(namespaceURI, qualifiedName, "newValue");
  addrAttr = ((Element) /*Node */testAddr).getAttributeNodeNS(namespaceURI, localName);
  resultAttr = ((Element) /*Node */testAddr).getAttributeNS(namespaceURI, localName);
  assertEquals("newValue", resultAttr, "attrValue");
  resultNamespaceURI = addrAttr.getNamespaceURI();
  assertEquals("http://www.newattr.com", resultNamespaceURI, "nsuri");
  resultLocalName = addrAttr.getLocalName();
  assertEquals("newAttr", resultLocalName, "lname");
  resultPrefix = addrAttr.getPrefix();
  assertEquals("emp", resultPrefix, "prefix");
 }
}