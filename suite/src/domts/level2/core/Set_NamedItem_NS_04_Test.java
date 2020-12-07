package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setNamedItemNS(arg)" method for a 
* NamedNodeMap should raise NO_MODIFICATION_ALLOWED_ERR DOMException if 
* this map is readonly.
* 
* Retrieve a list of "gender" elements. Get access to the THIRD element
* which contains an ENTITY_REFERENCE child node.  Get access to the node's
* map. Try to add an attribute node specified by arg with 
* method setNamedItemNS(arg).  This should result in NO_MODIFICATION_ALLOWED_ERR
* DOMException. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-setNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-setNamedItemNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
*/
class Set_NamedItem_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setNamedItemNS04")
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
  Node arg;
  Node setNode;
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
  arg = attributes.getNamedItemNS(namespaceURI, localName);
  {
   boolean success = false;
   try {
    setNode = attributes.setNamedItemNS(arg);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
  }
 }
}