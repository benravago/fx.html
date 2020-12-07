package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setNamedItem(arg)" method raises a 
* WRONG_DOCUMENT_ERR DOMException if "arg" was created
* from a different document than the one that created
* the NamedNodeMap. 
* 
* Create a NamedNodeMap object from the attributes of the
* last child of the third employee and attempt to add
* another Attr node to it that was created from a 
* different DOM document.  This should raise the desired
* exception.  This method uses the "createAttribute(name)"
* method from the Document interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='WRONG_DOCUMENT_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='WRONG_DOCUMENT_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-1025163788')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='WRONG_DOCUMENT_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-1025163788')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='WRONG_DOCUMENT_ERR'])</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=249">http://www.w3.org/Bugs/Public/show_bug.cgi?id=249</a>
*/
class NamedNodeMap_Wrong_Document_Err_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/namednodemapwrongdocumenterr")
 void run() throws Throwable {
  Document doc1;
  Document doc2;
  NodeList elementList;
  Node testAddress;
  NamedNodeMap attributes;
  Node newAttribute;
  Node setNode;
  doc1 = (Document) load("staff", true);
  doc2 = (Document) load("staff", true);
  elementList = doc1.getElementsByTagName("address");
  testAddress = elementList.item(2);
  newAttribute = doc2.createAttribute("newAttribute");
  attributes = testAddress.getAttributes();
  {
   boolean success = false;
   try {
    setNode = attributes.setNamedItem(newAttribute);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.WRONG_DOCUMENT_ERR);
   }
   assertTrue(success, "throw_WRONG_DOCUMENT_ERR");
  }
 }
}