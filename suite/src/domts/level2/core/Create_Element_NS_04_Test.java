package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createElementNS(namespaceURI,qualifiedName") method for
* a Document should raise NAMESPACE_ERR DOMException if the
* qualifiedName has an "xml" prefix and the namespaceURI is different
* from http://www.w3.org/XML/1998/namespace".
* 
* Invoke method createElementNS(namespaceURI,qualifiedName) on this document
* with qualifiedName being "xml:element1" and namespaceURI equals the string
* "http://www.w3.org/XML/1997/namespace" (which differs from the required 
* string "http://www.w3.org/XML/1998/namespace").
* Method should raise NAMESPACE_ERR DOMException.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrElNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrElNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-DocCrElNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-DocCrElNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])</a>
*/
class Create_Element_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createElementNS04")
 void run() throws Throwable {
  String namespaceURI = "http://www.w3.org/XML/1998/namespaces";
  String qualifiedName = "xml:element1";
  Document doc;
  Element newElement;
  doc = (Document) load("staffNS", false);
  {
   boolean success = false;
   try {
    newElement = doc.createElementNS(namespaceURI, qualifiedName);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NAMESPACE_ERR);
   }
   assertTrue(success, "throw_NAMESPACE_ERR");
  }
 }
}