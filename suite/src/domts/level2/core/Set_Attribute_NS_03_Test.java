package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNS(namespaceURI,qualifiedName,value)" method for an attribute causes the 
* DOMException NO_MODIFICATION_ALLOWED_ERR to be raised
* if the node is readonly.
* 
* Obtain the children of the THIRD "gender" element.  The elements
* content is an entity reference.  Try to set an attribute
* in the entity reference by executing the 
* "setAttributeNS(namespaceURI,qualifiedName,value)" method.
* This causes a NO_MODIFICATION_ALLOWED_ERR DOMException to be thrown.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
*/
class Set_Attribute_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setAttributeNS03")
 void run() throws Throwable {
  String namespaceURI = "www.xyz.com";
  String qualifiedName = "emp:local1";
  Document doc;
  NodeList genderList;
  Node gender;
  NodeList genList;
  Node gen;
  NodeList gList;
  Element genElement;
  int nodeType;
  doc = (Document) load("staffNS", true);
  genderList = doc.getElementsByTagName("gender");
  gender = genderList.item(2);
  genList = gender.getChildNodes();
  gen = genList.item(0);
  nodeType = (int) gen.getNodeType();
  if (equals(1, nodeType)) {
   gen = doc.createEntityReference("ent4");
   assertNotNull(gen, "createdEntRefNotNull");
  }
  gList = gen.getChildNodes();
  genElement = (Element) gList.item(0);
  assertNotNull(genElement, "notnull");
  {
   boolean success = false;
   try {
    genElement.setAttributeNS(namespaceURI, qualifiedName, "newValue");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
  }
 }
}