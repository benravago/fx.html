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
* The prefix will be changed to the prefix part of the "qualifiedName" 
* and its value changed to the "value" parameter.    
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#">http://www.w3.org/TR/DOM-Level-2-Core/core#</a>
*/
class Set_Attribute_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setAttributeNS04")
 void run() throws Throwable {
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
  ((Element) /*Node */testAddr).setAttributeNS("http://www.nist.gov", "newprefix:zone", "newValue");
  addrAttr = ((Element) /*Node */testAddr).getAttributeNodeNS("http://www.nist.gov", "zone");
  resultAttr = ((Element) /*Node */testAddr).getAttributeNS("http://www.nist.gov", "zone");
  assertEquals("newValue", resultAttr, "attrValue");
  resultNamespaceURI = addrAttr.getNamespaceURI();
  assertEquals("http://www.nist.gov", resultNamespaceURI, "nsuri");
  resultLocalName = addrAttr.getLocalName();
  assertEquals("zone", resultLocalName, "lname");
  resultPrefix = addrAttr.getPrefix();
  assertEquals("newprefix", resultPrefix, "prefix");
 }
}