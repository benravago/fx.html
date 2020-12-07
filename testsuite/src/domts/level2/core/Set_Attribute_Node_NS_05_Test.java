package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNodeNS(newAttr)" method raises an 
* "WRONG_DOCUMENT_ERR DOMException if the "newAttr" 
* was created from a different document than the one that
* created this document.
* 
* Retrieve the first emp:address and attempt to set a new
* attribute node.  The new
* attribute was created from a document other than the
* one that created this element, therefore a
* WRONG_DOCUMENT_ERR DOMException should be raised.
* This test uses the "createAttributeNS(newAttr)" method
* from the Document interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='WRONG_DOCUMENT_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='WRONG_DOCUMENT_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAtNodeNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='WRONG_DOCUMENT_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAtNodeNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='WRONG_DOCUMENT_ERR'])</a>
*/
class Set_Attribute_Node_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/setAttributeNodeNS05")
 void run() throws Throwable {
  String namespaceURI = "http://www.newattr.com";
  String qualifiedName = "emp:newAttr";
  Document doc1;
  Document doc2;
  Attr newAttr;
  NodeList elementList;
  Node testAddr;
  Attr setAttr1;
  doc1 = (Document) load("staffNS", true);
  doc2 = (Document) load("staffNS", true);
  newAttr = doc2.createAttributeNS(namespaceURI, qualifiedName);
  elementList = doc1.getElementsByTagName("emp:address");
  testAddr = elementList.item(0);
  {
   boolean success = false;
   try {
    setAttr1 = ((Element) /*Node */testAddr).setAttributeNodeNS(newAttr);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.WRONG_DOCUMENT_ERR);
   }
   assertTrue(success, "throw_WRONG_DOCUMENT_ERR");
  }
 }
}