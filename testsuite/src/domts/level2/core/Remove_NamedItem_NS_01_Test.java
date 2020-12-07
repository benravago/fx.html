package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeNamedItemNS(namespaceURI,localName)" method for a 
* NamedNodeMap should remove a node specified by localName and namespaceURI.
* 
* Retrieve a list of elements with tag name "address".
* Access the second element from the list and get its attributes.
* Try to remove the attribute node with local name "domestic"
* and namespace uri "http://www.usa.com" with 
* method removeNamedItemNS(namespaceURI,localName).
* Check to see if the node has been removed. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1074577549">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1074577549</a>
*/
class Remove_NamedItem_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/removeNamedItemNS01")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testAddress;
  NamedNodeMap attributes;
  Attr newAttr;
  Node removedNode;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("address");
  testAddress = elementList.item(1);
  attributes = testAddress.getAttributes();
  removedNode = attributes.removeNamedItemNS("http://www.usa.com", "domestic");
  assertNotNull(removedNode, "retval");
  newAttr = (Attr) attributes.getNamedItem("dmstc:domestic");
  assertNull(newAttr, "nodeRemoved");
 }
}