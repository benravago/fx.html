package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNamedItemNS(namespaceURI,localName)" method for a 
* NamedNodeMap should return null
* if parameters do not identify any node in this map.
* 
* Retrieve a list of elements with tag name "address".
* Access the second element from the list and get its attributes.
* Try to retrieve an attribute node with local name "domest"
* and namespace uri "http://www.usa.com" with
* method getNamedItemNS(namespaceURI,localName).
* This should return null because "domest" does not match any local names in this map.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
*/
class Get_NamedItem_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getNamedItemNS02")
 void run() throws Throwable {
  String namespaceURI = "http://www.usa.com";
  String localName = "domest";
  Document doc;
  NodeList elementList;
  Node testEmployee;
  NamedNodeMap attributes;
  Attr newAttr;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagName("address");
  testEmployee = elementList.item(1);
  attributes = testEmployee.getAttributes();
  newAttr = (Attr) attributes.getNamedItemNS(namespaceURI, localName);
  assertNull(newAttr, "throw_Null");
 }
}