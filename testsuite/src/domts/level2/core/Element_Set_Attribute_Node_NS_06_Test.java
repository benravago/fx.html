package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setAttributeNodeNS Adds a new attribute and raises an WRONG_DOCUMENT_ERR if this node 
* is readonly.
* Attempt to add an attribute node to an element node which is part of the replacement text of 
* a read-only EntityReference node.
* Check if a NO_MODIFICATION_ALLOWED_ERR is thrown.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
*/
@Disabled("2")
class Element_Set_Attribute_Node_NS_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setExpandEntityReferences(false);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributenodens06")
 void run() throws Throwable {
  Document doc;
  Element element;
  Attr attribute;
  Attr attribute2;
  EntityReference entRef;
  NodeList elementList;
  Node newAttribute;
  Node newChild;
  doc = (Document) load("staffNS", true);
  element = doc.createElementNS("http://www.w3.org/DOM/Test", "elem1");
  attribute = doc.createAttributeNS("http://www.w3.org/DOM/Test", "attr");
  entRef = doc.createEntityReference("ent4");
  newChild = attribute.appendChild(entRef);
  newAttribute = element.setAttributeNodeNS(attribute);
  elementList = entRef.getChildNodes();
  element = (Element) elementList.item(0);
  attribute2 = doc.createAttributeNS("http://www.w3.org/DOM/Test", "attr2");
  {
   boolean success = false;
   try {
    newAttribute = element.setAttributeNodeNS(attribute2);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "elementsetattributenodens06");
  }
 }
}