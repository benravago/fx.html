package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retreive an entity and notation node and remove the first notation from the 
* entity node map and first entity node from the notation map.  Since both these
* maps are readonly, a NO_MODIFICATION_ALLOWED_ERR should be raised.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=407">http://www.w3.org/Bugs/Public/show_bug.cgi?id=407</a>
* @see <a href="http://lists.w3.org/Archives/Member/w3c-dom-ig/2003Nov/0016.html">http://lists.w3.org/Archives/Member/w3c-dom-ig/2003Nov/0016.html</a>
*/
class NamedNode_Map_Remove_NamedItem_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapremovenameditemns05")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entities;
  NamedNodeMap notations;
  Node removedNode;
  String nullNS = null;
  doc = (Document) load("staffNS", true);
  docType = doc.getDoctype();
  entities = docType.getEntities();
  assertNotNull(entities, "entitiesNotNull");
  notations = docType.getNotations();
  assertNotNull(notations, "notationsNotNull");
  try {
   removedNode = entities.removeNamedItemNS(nullNS, "ent1");
   fail("entity_throw_DOMException");
  } catch (DOMException ex) {
   switch (ex.code) {
    case 8:
     break;
    case 7:
     break;
    default:
     throw ex;
   }
  }
  try {
   removedNode = notations.removeNamedItemNS(nullNS, "notation1");
   fail("notation_throw_DOMException");
  } catch (DOMException ex) {
   switch (ex.code) {
    case 8:
     break;
    case 7:
     break;
    default:
     throw ex;
   }
  }
 }
}