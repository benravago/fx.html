package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setPrefix(prefix)" method raises a 
* NAMESPACE_ERR DOMException if the specified node is an attribute
* and the specified prefix is xmlns and the namespaceURI is different from
* http://www.w3.org/2000/xmlns.
* 
* Attempt to insert "xmlns" as the new namespace prefix on the emp:domestic
* attribute within the emp:address node.
* An exception should be raised since the namespaceURI of this node is not 
* http://www.w3.org/2000/xmlns.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-NodeNSPrefix')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-NodeNSPrefix')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])</a>
*/
class Prefix_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/prefix05")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element addrNode;
  Attr addrAttr;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("emp:address");
  addrNode = (Element) elementList.item(0);
  assertNotNull(addrNode, "empAddrNotNull");
  addrAttr = addrNode.getAttributeNode("emp:domestic");
  {
   boolean success = false;
   try {
    addrAttr.setPrefix("xmlns");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "throw_NAMESPACE_ERR");
  }
 }
}