package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeAttributeNS(namespaceURI,localName)" removes an attribute by 
* local name and namespace URI.  If the removed attribute has a
* default value it is immediately replaced.  The replacing attribute has the same
* namespace URI and local name, as well as the original prefix.
* 
* Retrieve the attribute named "emp:local" from emp:address
* node, then remove the "emp:local" 
* attribute by invoking the "removeAttributeNS(namespaceURI,localName)" method.
* The "emp:local" attribute has a default value defined in the
* DTD file, that value should immediately replace the old
* value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElRemAtNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElRemAtNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=238">http://www.w3.org/Bugs/Public/show_bug.cgi?id=238</a>
*/
class Remove_Attribute_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/removeAttributeNS02")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testAddr;
  Attr addrAttr;
  String attr;
  String namespaceURI;
  String localName;
  String prefix;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = elementList.item(0);
  ((Element) /*Node */testAddr).removeAttributeNS("http://www.nist.gov", "local1");
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = elementList.item(0);
  addrAttr = ((Element) /*Node */testAddr).getAttributeNodeNS("http://www.nist.gov", "local1");
  attr = ((Element) /*Node */testAddr).getAttributeNS("http://www.nist.gov", "local1");
  namespaceURI = addrAttr.getNamespaceURI();
  localName = addrAttr.getLocalName();
  prefix = testAddr.getPrefix();
  assertEquals("FALSE", attr, "attr");
  assertEquals("http://www.nist.gov", namespaceURI, "uri");
  assertEquals("local1", localName, "lname");
  assertEquals("emp", prefix, "prefix");
 }
}