package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setNamedItemNS adds a node using its namespaceURI and localName and 
* raises a NO_MODIFICATION_ALLOWED_ERR if this map is readonly.
* 
* Create a new attribute node and attempt to add it to the nodemap of entities and notations
* for this documenttype.  This should reaise a NO_MODIFICATION_ALLOWED_ERR.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
*/
class NamedNode_Map_Set_NamedItem_NS_09_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapsetnameditemns09")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entities;
  NamedNodeMap notations;
  Attr attr;
  Node newNode;
  doc = (Document) load("staffNS", true);
  docType = doc.getDoctype();
  entities = docType.getEntities();
  notations = docType.getNotations();
  attr = doc.createAttributeNS("http://www.w3.org/DOM/Test", "test");
  {
   boolean success = false;
   try {
    newNode = entities.setNamedItemNS(attr);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR_entities");
  }
  {
   boolean success = false;
   try {
    newNode = notations.setNamedItemNS(attr);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR_notations");
  }
 }
}