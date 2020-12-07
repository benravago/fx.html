package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNS(namespaceURI,localName,value)" method raises a 
* NAMESPACE_ERR DOMException if the "qualifiedName" has a
* value of "xmlns" and the namespaceURI is different from
* http://www.w3.org/2000/xmlns.
* 
* Attempt to add an attribute with a "qualifiedName" of "xmlns" as the 
* on the first employee node.
* An exception should be raised since the namespaceURI of this node is not 
* http://www.w3.org/2000/xmlns.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])</a>
*/
class Set_Attribute_NS_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setAttributeNS07")
 void run() throws Throwable {
  String namespaceURI = "http://www.nist.gov";
  String qualifiedName = "xmlns";
  Document doc;
  NodeList elementList;
  Node testAddr;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("employee");
  testAddr = elementList.item(0);
  {
   boolean success = false;
   try {
    ((Element) /*Node */testAddr).setAttributeNS(namespaceURI, qualifiedName, "newValue");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "throw_NAMESPACE_ERR");
  }
 }
}