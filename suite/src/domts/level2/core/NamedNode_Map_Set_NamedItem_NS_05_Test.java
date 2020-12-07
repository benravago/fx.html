package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retreive an entity and notation node and add the first notation to the 
* notation node map and first entity node to the entity map.  Since both these
* maps are for readonly node, a NO_MODIFICATION_ALLOWED_ERR should be raised.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=407">http://www.w3.org/Bugs/Public/show_bug.cgi?id=407</a>
* @see <a href="http://lists.w3.org/Archives/Member/w3c-dom-ig/2003Nov/0016.html">http://lists.w3.org/Archives/Member/w3c-dom-ig/2003Nov/0016.html</a>
*/
class NamedNode_Map_Set_NamedItem_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapsetnameditemns05")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entities;
  NamedNodeMap notations;
  Entity entity;
  Notation notation;
  Node newNode;
  String nullNS = null;
  doc = (Document) load("staffNS", true);
  docType = doc.getDoctype();
  entities = docType.getEntities();
  assertNotNull(entities, "entitiesNotNull");
  notations = docType.getNotations();
  assertNotNull(notations, "notationsNotNull");
  entity = (Entity) entities.getNamedItem("ent1");
  notation = (Notation) notations.getNamedItem("notation1");
  {
   boolean success = false;
   try {
    newNode = entities.setNamedItemNS(entity);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR_entities");
  }
  {
   boolean success = false;
   try {
    newNode = notations.setNamedItemNS(notation);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR_notations");
  }
 }
}