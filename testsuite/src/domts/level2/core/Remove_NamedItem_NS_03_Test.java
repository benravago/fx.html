package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeNamedItemNS(namespaceURI,localName)" method for a 
* NamedNodeMap should raise NO_MODIFICATION_ALLOWED_ERR DOMException if
* this map is readonly.
* 
* Retrieve a list of "gender" elements. Get access to the THIRD element
* which contains an ENTITY_REFERENCE child node.  Try to remove the attribute
* in the node's map with method removeNamedItemNS(namespaceURI,localName).
* This should result in NO_MODIFICATION_ALLOWED_ERR
* DOMException.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-removeNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-removeNamedItemNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-removeNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-removeNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
*/
class Remove_NamedItem_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/removeNamedItemNS03")
 void run() throws Throwable {
  String namespaceURI = "http://www.w3.org/2000/xmlns/";
  String localName = "local1";
  Document doc;
  NodeList elementList;
  Node testAddress;
  NodeList nList;
  Node child;
  NodeList n2List;
  Node child2;
  NamedNodeMap attributes;
  Node removedNode;
  int nodeType;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("gender");
  testAddress = elementList.item(2);
  nList = testAddress.getChildNodes();
  child = nList.item(0);
  nodeType = (int) child.getNodeType();
  if (equals(1, nodeType)) {
   child = doc.createEntityReference("ent4");
   assertNotNull(child, "createdEntRefNotNull");
  }
  n2List = child.getChildNodes();
  child2 = n2List.item(0);
  assertNotNull(child2, "notnull");
  attributes = child2.getAttributes();
  {
   boolean success = false;
   try {
    removedNode = attributes.removeNamedItemNS(namespaceURI, localName);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
  }
 }
}