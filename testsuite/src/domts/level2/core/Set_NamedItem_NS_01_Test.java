package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setNamedItemNS(arg)" method for a 
* NamedNodeMap should raise INUSE_ATTRIBUTE_ERR DOMException if 
* arg is an Attr that is already an attribute of another Element object.
* 
* Retrieve an attr node from the third "address" element whose local name
* is "domestic" and namespaceURI is "http://www.netzero.com".
* Invoke method setNamedItemNS(arg) on the map of the first "address" element with
* arg being the attr node from above.  Method should raise
* INUSE_ATTRIBUTE_ERR DOMException.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-setNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-setNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])</a>
*/
class Set_NamedItem_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setNamedItemNS01")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node anotherElement;
  NamedNodeMap anotherMap;
  Node arg;
  Node testAddress;
  NamedNodeMap map;
  Node setNode;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("address");
  anotherElement = elementList.item(2);
  anotherMap = anotherElement.getAttributes();
  arg = anotherMap.getNamedItemNS("http://www.netzero.com", "domestic");
  testAddress = elementList.item(0);
  map = testAddress.getAttributes();
  {
   boolean success = false;
   try {
    setNode = map.setNamedItemNS(arg);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INUSE_ATTRIBUTE_ERR);
   }
   assertTrue(success, "throw_INUSE_ATTRIBUTE_ERR");
  }
 }
}