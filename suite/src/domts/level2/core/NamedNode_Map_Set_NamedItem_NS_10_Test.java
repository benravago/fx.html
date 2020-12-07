package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setNamedItemNS adds a node using its namespaceURI and localName and 
* raises a HIERARCHY_REQUEST_ERR if an attempt is made to add a node doesn't belong 
* in this NamedNodeMap.
* Attempt to add an entity to a NamedNodeMap of attribute nodes,
* Since nodes of this type cannot be added to the attribute node map a HIERARCHY_REQUEST_ERR
* should be raised.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class NamedNode_Map_Set_NamedItem_NS_10_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapsetnameditemns10")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entities;
  NamedNodeMap attributes;
  Entity entity;
  Notation notation;
  Element element;
  NodeList elementList;
  Node newNode;
  doc = (Document) load("staffNS", true);
  docType = doc.getDoctype();
  entities = docType.getEntities();
  assertNotNull(entities, "entitiesNotNull");
  entity = (Entity) entities.getNamedItem("ent1");
  elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
  element = (Element) elementList.item(0);
  attributes = element.getAttributes();
  {
   boolean success = false;
   try {
    newNode = attributes.setNamedItemNS(entity);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.HIERARCHY_REQUEST_ERR);
   }
   assertTrue(success, "throw_HIERARCHY_REQUEST_ERR");
  }
 }
}