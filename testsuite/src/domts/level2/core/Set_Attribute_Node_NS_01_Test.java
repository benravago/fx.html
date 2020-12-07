package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNode(newAttr)" method raises an 
* "INUSE_ATTRIBUTE_ERR DOMException if the "newAttr" 
* is already an attribute of another element.
* 
* Retrieve the first emp:address and append
* a newly created element.  The "createAttributeNS(namespaceURI,qualifiedName)"
* and "setAttributeNodeNS(newAttr)" methods are invoked
* to create and add a new attribute to the newly created
* Element.  The "setAttributeNodeNS(newAttr)" method is
* once again called to add the new attribute causing an
* exception to be raised since the attribute is already
* an attribute of another element.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAtNodeNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAtNodeNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])</a>
*/
class Set_Attribute_Node_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setAttributeNodeNS01")
 void run() throws Throwable {
  String namespaceURI = "http://www.newattr.com";
  String qualifiedName = "emp:newAttr";
  Document doc;
  Element newElement;
  Attr newAttr;
  NodeList elementList;
  Node testAddr;
  Node appendedChild;
  Attr setAttr1;
  Attr setAttr2;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("emp:address");
  testAddr = elementList.item(0);
  assertNotNull(testAddr, "empAddrNotNull");
  newElement = doc.createElement("newElement");
  appendedChild = testAddr.appendChild(newElement);
  newAttr = doc.createAttributeNS(namespaceURI, qualifiedName);
  setAttr1 = newElement.setAttributeNodeNS(newAttr);
  {
   boolean success = false;
   try {
    setAttr2 = ((Element) /*Node */testAddr).setAttributeNodeNS(newAttr);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INUSE_ATTRIBUTE_ERR);
   }
   assertTrue(success, "throw_INUSE_ATTRIBUTE_ERR");
  }
 }
}