package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Using the method getNamedItemNS, retreive the entity "ent1" and notation "notation1" 
* from a NamedNodeMap of this DocumentTypes entities and notations.
* Both should be null since entities and notations are not namespaced.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=407">http://www.w3.org/Bugs/Public/show_bug.cgi?id=407</a>
* @see <a href="http://lists.w3.org/Archives/Member/w3c-dom-ig/2003Nov/0016.html">http://lists.w3.org/Archives/Member/w3c-dom-ig/2003Nov/0016.html</a>
*/
@Disabled("2")
class NamedNode_Map_Get_NamedItem_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapgetnameditemns01")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entities;
  NamedNodeMap notations;
  Entity entity;
  Notation notation;
  String entityName;
  String notationName;
  String nullNS = null;
  doc = (Document) load("staffNS", false);
  docType = doc.getDoctype();
  entities = docType.getEntities();
  assertNotNull(entities, "entitiesNotNull");
  notations = docType.getNotations();
  assertNotNull(notations, "notationsNotNull");
  entity = (Entity) entities.getNamedItemNS(nullNS, "ent1");
  assertNull(entity, "entityNull");
  notation = (Notation) notations.getNamedItemNS(nullNS, "notation1");
  assertNull(notation, "notationNull");
 }
}