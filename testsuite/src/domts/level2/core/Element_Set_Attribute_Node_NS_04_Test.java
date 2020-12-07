package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setAttributeNodeNS Adds a new attribute and raises an INUSE_ATTRIBUTE_ERR 
* if newAttr is already an attribute of another Element object. 
* 
* Create two new element nodes and a new attribute node.  Attempt to add the same attribute
* node to the same two element nodes.
* Check if an INUSE_ATTRIBUTE_ERR is thrown.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
*/
class Element_Set_Attribute_Node_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributenodens04")
 void run() throws Throwable {
  Document doc;
  Element element1;
  Element element2;
  Attr attribute;
  Attr newAttribute;
  doc = (Document) load("staffNS", true);
  element1 = doc.createElementNS("http://www.w3.org/DOM/Test", "elem1");
  element2 = doc.createElementNS("http://www.w3.org/DOM/Test", "elem2");
  attribute = doc.createAttributeNS("http://www.w3.org/DOM/Test", "attr");
  newAttribute = element1.setAttributeNodeNS(attribute);
  {
   boolean success = false;
   try {
    newAttribute = element2.setAttributeNodeNS(attribute);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INUSE_ATTRIBUTE_ERR);
   }
   assertTrue(success, "elementsetattributenodens04");
  }
 }
}