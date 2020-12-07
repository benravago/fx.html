package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNamespaceURI()" method for an Attribute
* returns the namespace URI of this node, or null if unspecified.
* 
* Retrieve the first "emp:address" node which has an attribute of "emp:district"
* that is specified in the DTD.
* Invoke the "getNamespaceURI()" method on the attribute.   
* The method should return "http://www.nist.gov". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSname">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSname</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=238">http://www.w3.org/Bugs/Public/show_bug.cgi?id=238</a>
*/
class Namespace_URI_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namespaceURI01")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  Attr addrAttr;
  String attrNamespaceURI;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = (Element) elementList.item(0);
  addrAttr = testAddr.getAttributeNodeNS("http://www.nist.gov", "district");
  attrNamespaceURI = addrAttr.getNamespaceURI();
  assertEquals("http://www.nist.gov", attrNamespaceURI, "namespaceURI");
 }
}