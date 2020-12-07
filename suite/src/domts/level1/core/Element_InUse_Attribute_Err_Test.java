package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNode(newAttr)" method raises an 
* "INUSE_ATTRIBUTE_ERR DOMException if the "newAttr" 
* is already an attribute of another element.
* 
* Retrieve the last child of the second employee and append
* a newly created element.  The "createAttribute(name)"
* and "setAttributeNode(newAttr)" methods are invoked
* to create and add a new attribute to the newly created
* Element.  The "setAttributeNode(newAttr)" method is
* once again called to add the new attribute causing an
* exception to be raised since the attribute is already
* an attribute of another element.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-887236154')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-887236154')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])</a>
*/
@Disabled("fx")
class Element_InUse_Attribute_Err_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementinuseattributeerr")
 void run() throws Throwable {
  Document doc;
  Attr newAttribute;
  NodeList addressElementList;
  Element testAddress;
  Element newElement;
  Node appendedChild;
  Attr setAttr1;
  Attr setAttr2;
  doc = (Document) load("staff", true);
  addressElementList = doc.getElementsByTagName("address");
  testAddress = (Element) addressElementList.item(1);
  newElement = doc.createElement("newElement");
  appendedChild = testAddress.appendChild(newElement);
  newAttribute = doc.createAttribute("newAttribute");
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