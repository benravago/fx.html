package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* An attempt to add remove an entity should result in a NO_MODIFICATION_ERR.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1788794630">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1788794630</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D58B193">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D58B193</a>
*/
class HC_Entities_Remove_Named_Item_1_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  feature("XML");
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_entitiesremovenameditem1")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap entities;
  DocumentType docType;
  Node retval;
  doc = (Document) load("hc_staff", true);
  docType = doc.getDoctype();
  if (!(("text/html".equals(getContentType())))) {
   assertNotNull(docType, "docTypeNotNull");
   entities = docType.getEntities();
   assertNotNull(entities, "entitiesNotNull");
   {
    boolean success = false;
    try {
     retval = entities.removeNamedItem("alpha");
    } catch (DOMException ex) {
     success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
    }
    assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
   }
  }
 }
}