package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeNamedItemNS(namespaceURI,localName)" method for a 
* NamedNodeMap should raise NOT_FOUND_ERR DOMException if
* there is no node with the specified namespaceURI and localName in this map.
* 
* Retrieve a list of elements with tag name "address".
* Access the second element from the list and get its attributes.
* Try to remove an attribute node with local name "domest"
* and namespace uri "http://www.usa.com" with 
* method removeNamedItemNS(namespaceURI,localName).
* This should raise NOT_FOUND_ERR DOMException.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NOT_FOUND_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NOT_FOUND_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-removeNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-removeNamedItemNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-removeNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NOT_FOUND_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-removeNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NOT_FOUND_ERR'])</a>
*/
class Remove_NamedItem_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/removeNamedItemNS02")
 void run() throws Throwable {
  String namespaceURI = "http://www.usa.com";
  String localName = "domest";
  Document doc;
  NodeList elementList;
  Node testAddress;
  NamedNodeMap attributes;
  Node removedNode;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("address");
  testAddress = elementList.item(1);
  attributes = testAddress.getAttributes();
  {
   boolean success = false;
   try {
    removedNode = attributes.removeNamedItemNS(namespaceURI, localName);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NOT_FOUND_ERR);
   }
   assertTrue(success, "throw_NOT_FOUND_ERR");
  }
 }
}