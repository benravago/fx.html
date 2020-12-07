package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setNamedItemNS(arg)" method for a 
* NamedNodeMap should raise WRONG_DOCUMENT_ERR DOMException if arg was
* created from a different document than the one that created this map.
* 
* Create an attr node in a different document with qualifiedName equals
* "dmstc:domestic" and namespaceURI is "http://www.usa.com".
* Access the namednodemap of the first "address" element in this document.
* Invoke method setNamedItemNS(arg) with arg being the attr node from above.
* Method should raise WRONG_DOCUMENT_ERR DOMException.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='WRONG_DOCUMENT_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='WRONG_DOCUMENT_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-setNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='WRONG_DOCUMENT_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-setNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='WRONG_DOCUMENT_ERR'])</a>
*/
class Set_NamedItem_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setNamedItemNS02")
 void run() throws Throwable {
  String namespaceURI = "http://www.usa.com";
  String qualifiedName = "dmstc:domestic";
  Document doc;
  Document anotherDoc;
  Node arg;
  NodeList elementList;
  Node testAddress;
  NamedNodeMap attributes;
  Node setNode;
  doc = (Document) load("staffNS", true);
  anotherDoc = (Document) load("staffNS", true);
  arg = anotherDoc.createAttributeNS(namespaceURI, qualifiedName);
  arg.setNodeValue("Maybe");
  elementList = doc.getElementsByTagName("address");
  testAddress = elementList.item(0);
  attributes = testAddress.getAttributes();
  {
   boolean success = false;
   try {
    setNode = attributes.setNamedItemNS(arg);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.WRONG_DOCUMENT_ERR);
   }
   assertTrue(success, "throw_WRONG_DOCUMENT_ERR");
  }
 }
}