package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setAttributeNodeNS Adds a new attribute and raises 
* an WRONG_DOCUMENT_ERR if newAttr was created from a different document 
* than the one that created the element.
* Create new element and attribute nodes in different documents.  
* Attempt to add the attribute node to the element node.
* Check if an WRONG_DOCUMENT_ERR is thrown.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
*/
class Element_Set_Attribute_Node_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributenodens05")
 void run() throws Throwable {
  Document doc;
  Document docAlt;
  Element element;
  Attr attribute;
  Attr newAttribute;
  doc = (Document) load("staffNS", true);
  docAlt = (Document) load("staffNS", true);
  element = doc.createElementNS("http://www.w3.org/DOM/Test", "elem1");
  attribute = docAlt.createAttributeNS("http://www.w3.org/DOM/Test", "attr");
  {
   boolean success = false;
   try {
    newAttribute = element.setAttributeNodeNS(attribute);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.WRONG_DOCUMENT_ERR);
   }
   assertTrue(success, "throw_WRONG_DOCUMENT_ERR");
  }
 }
}