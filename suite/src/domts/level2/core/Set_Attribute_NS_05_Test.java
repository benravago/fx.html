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
* Check to see if the new attribute has been successfully added to the document.
* The new attribute "<newValue>" contains markup and therefore is escaped
* by the implementation.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS</a>
*/
class Set_Attribute_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setAttributeNS05")
 void run() throws Throwable {
  String localName = "newAttr";
  String namespaceURI = "http://www.newattr.com";
  String qualifiedName = "emp:newAttr";
  Document doc;
  NodeList elementList;
  Node testAddr;
  Attr addrAttr;
  String resultAttr;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = elementList.item(0);
  assertNotNull(testAddr, "empAddrNotNull");
  ((Element) /*Node */testAddr).setAttributeNS(namespaceURI, qualifiedName, "<newValue>");
  resultAttr = ((Element) /*Node */testAddr).getAttributeNS(namespaceURI, localName);
  assertEquals("<newValue>", resultAttr, "throw_Equals");
 }
}