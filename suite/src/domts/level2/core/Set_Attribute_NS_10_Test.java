package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Element.setAttributeNS with an empty qualified name should cause an INVALID_CHARACTER_ERR.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INVALID_CHARACTER_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=525">http://www.w3.org/Bugs/Public/show_bug.cgi?id=525</a>
*/
@Disabled("2")
class Set_Attribute_NS_10_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setAttributeNS10")
 void run() throws Throwable {
  String namespaceURI = "http://www.example.gov";
  Document doc;
  NodeList elementList;
  Node testAddr;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("em");
  testAddr = elementList.item(0);
  {
   boolean success = false;
   try {
    ((Element) /*Node */testAddr).setAttributeNS(namespaceURI, "", "newValue");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
   }
   assertTrue(success, "throw_INVALID_CHARACTER_ERR");
  }
 }
}