package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Entity nodes are not namespaced and should not be retrievable using
* getNamedItemNS.
* @author Curt Arnold
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
@Disabled("2")
class Get_NamedItem_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getNamedItemNS03")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entities;
  Entity entity;
  String nullNS = null;
  doc = (Document) load("staffNS", false);
  docType = doc.getDoctype();
  entities = docType.getEntities();
  assertNotNull(entities, "entitiesNotNull");
  entity = (Entity) entities.getNamedItemNS(nullNS, "ent1");
  assertNull(entity, "entityNull");
 }
}