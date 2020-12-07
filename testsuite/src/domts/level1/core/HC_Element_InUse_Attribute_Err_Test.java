package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNode(newAttr)" method raises an 
* "INUSE_ATTRIBUTE_ERR DOMException if the "newAttr" 
* is already an attribute of another element.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-887236154')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-887236154')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=244">http://www.w3.org/Bugs/Public/show_bug.cgi?id=244</a>
*/
@Disabled("fx")
class HC_Element_InUse_Attribute_Err_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementinuseattributeerr")
 void run() throws Throwable {
  Document doc;
  Attr newAttribute;
  NodeList addressElementList;
  Element testAddress;
  Element newElement;
  Attr attrAddress;
  Node appendedChild;
  Attr setAttr1;
  Attr setAttr2;
  doc = (Document) load("hc_staff", true);
  addressElementList = doc.getElementsByTagName("body");
  testAddress = (Element) addressElementList.item(0);
  newElement = doc.createElement("p");
  appendedChild = testAddress.appendChild(newElement);
  newAttribute = doc.createAttribute("title");
  setAttr1 = newElement.setAttributeNode(newAttribute);
  {
   boolean success = false;
   try {
    setAttr2 = testAddress.setAttributeNode(newAttribute);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INUSE_ATTRIBUTE_ERR);
   }
   assertTrue(success, "throw_INUSE_ATTRIBUTE_ERR");
  }
 }
}