package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNodeNS(namespaceURI,qualifiedName,value)" method for an attribute causes the 
* DOMException NO_MODIFICATION_ALLOWED_ERR to be raised
* if the node is readonly.
* 
* Obtain the children of the THIRD "gender" element.  The elements
* content is an entity reference.  Try to set an attribute
* in the entity reference by executing the 
* "setAttributeNodeNS(newAttr)" method.
* This causes a NO_MODIFICATION_ALLOWED_ERR DOMException to be thrown.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAtNodeNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAtNodeNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
*/
class Set_Attribute_Node_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(false);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setAttributeNodeNS02")
 void run() throws Throwable {
  Document doc;
  NodeList genderList;
  Node gender;
  NodeList genList;
  Node gen;
  NodeList gList;
  Element genElement;
  Attr newAttr;
  Attr setAttr1;
  doc = (Document) load("staffNS", true);
  if (!isExpandEntityReferences()) {
   genderList = doc.getElementsByTagName("gender");
   gender = genderList.item(2);
   genList = gender.getChildNodes();
   gen = genList.item(0);
  } else {
   gen = doc.createEntityReference("ent4");
  }
  gList = gen.getChildNodes();
  genElement = (Element) gList.item(0);
  assertNotNull(genElement, "notnull");
  newAttr = doc.createAttributeNS("www.xyz.com", "emp:local1");
  {
   boolean success = false;
   try {
    setAttr1 = genElement.setAttributeNodeNS(newAttr);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
  }
 }
}