package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNode(newAttr)" method raises an 
* "WRONG_DOCUMENT_ERR DOMException if the "newAttr" 
* was created from a different document than the one that
* created this document.
* Retrieve the last employee and attempt to set a new
* attribute node for its "employee" element.  The new
* attribute was created from a document other than the
* one that created this element, therefore a
* WRONG_DOCUMENT_ERR DOMException should be raised.
* This test uses the "createAttribute(newAttr)" method
* from the Document interface.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='WRONG_DOCUMENT_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='WRONG_DOCUMENT_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-887236154')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='WRONG_DOCUMENT_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-887236154')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='WRONG_DOCUMENT_ERR'])</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=249">http://www.w3.org/Bugs/Public/show_bug.cgi?id=249</a>
*/
class HC_Element_Wrong_Document_Err_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_elementwrongdocumenterr")
 void run() throws Throwable {
  Document doc1;
  Document doc2;
  Attr newAttribute;
  NodeList addressElementList;
  Element testAddress;
  Attr attrAddress;
  doc1 = (Document) load("hc_staff", true);
  doc2 = (Document) load("hc_staff", false);
  newAttribute = doc2.createAttribute("newAttribute");
  addressElementList = doc1.getElementsByTagName("acronym");
  testAddress = (Element) addressElementList.item(4);
  {
   boolean success = false;
   try {
    attrAddress = testAddress.setAttributeNode(newAttribute);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.WRONG_DOCUMENT_ERR);
   }
   assertTrue(success, "throw_WRONG_DOCUMENT_ERR");
  }
 }
}