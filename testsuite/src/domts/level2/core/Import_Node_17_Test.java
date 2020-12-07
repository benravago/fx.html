package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "importNode(importedNode,deep)" method for a 
* Document should raise NOT_SUPPORTED_ERR DOMException if
* the type of node being imported is Document.
* 
* Retrieve staff.xml document.
* Invoke method importNode(importedNode,deep) where importedNode
* contains staff.xml and deep is true.
* Method should raise NOT_SUPPORTED_ERR DOMException.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NOT_SUPPORTED_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NOT_SUPPORTED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Core-Document-importNode')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NOT_SUPPORTED_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Core-Document-importNode')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NOT_SUPPORTED_ERR'])</a>
*/
class Import_Node_17_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/importNode17")
 void run() throws Throwable {
  Document doc;
  Document anotherDoc;
  Node node;
  doc = (Document) load("staffNS", true);
  anotherDoc = (Document) load("staffNS", true);
  {
   boolean success = false;
   try {
    node = doc.importNode(anotherDoc, false);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NOT_SUPPORTED_ERR);
   }
   assertTrue(success, "throw_NOT_SUPPORTED_ERR");
  }
 }
}