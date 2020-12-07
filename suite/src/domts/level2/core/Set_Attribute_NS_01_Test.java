package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNS(namespaceURI,qualifiedName,Value)" method raises a 
* INVALID_CHARACTER_ERR DOMException if the specified
* prefix contains an illegal character.
* 
* Attempt to add a new attribute on the first employee node.
* An exception should be raised since the "qualifiedName" has an invalid 
* character.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INVALID_CHARACTER_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])</a>
*/
class Set_Attribute_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setAttributeNS01")
 void run() throws Throwable {
  String namespaceURI = "http://www.nist.gov";
  String qualifiedName = "emp:qual?name";
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
    success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
   }
   assertTrue(success, "throw_INVALID_CHARACTER_ERR");
  }
 }
}