package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getLocalName()" method for a Node
* returns the local part of the qualified name of this node,
* and for nodes of any type other than ELEMENT_NODE and ATTRIBUTE_NODE
* and nodes created with a DOM Level 1 method, this is null.
* 
* Retrieve the first emp:address node and get the attributes of this node."   
* Then apply the getLocalName() method to the emp:domestic attribute.
* The method should return "domestic". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSLocalN</a>
*/
class LocalName_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/localName01")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  Attr addrAttr;
  String localName;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = (Element) elementList.item(0);
  assertNotNull(testAddr, "empAddrNotNull");
  addrAttr = testAddr.getAttributeNode("emp:domestic");
  localName = addrAttr.getLocalName();
  assertEquals("domestic", localName, "localName");
 }
}