package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* An attempt to add an element to the named node map returned by entities should 
* result in a NO_MODIFICATION_ERR or HIERARCHY_REQUEST_ERR.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1788794630">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1788794630</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
*/
class HC_Entities_Set_NamedItem_NS_1_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/hc_entitiessetnameditemns1")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap entities;
  DocumentType docType;
  Node retval;
  Element elem;
  doc = (Document) load("hc_staff", true);
  docType = doc.getDoctype();
  if (!(("text/html".equals(getContentType())))) {
   assertNotNull(docType, "docTypeNotNull");
   entities = docType.getEntities();
   assertNotNull(entities, "entitiesNotNull");
   elem = doc.createElementNS("http://www.w3.org/1999/xhtml", "br");
   try {
    retval = entities.setNamedItemNS(elem);
    fail("throw_HIER_OR_NO_MOD_ERR");
   } catch (DOMException ex) {
    switch (ex.code) {
     case 3:
      break;
     case 7:
      break;
     default:
      throw ex;
    }
   }
  }
 }
}