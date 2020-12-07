package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Duplicate entities are to be discarded. 
* Retrieve the Document Type for this document and create 
* a NamedNodeMap of all its entities.  The entity named 
* "ent1" is defined twice and therefore that last 
* occurrance should be discarded.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1788794630">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1788794630</a>
*/
class DocumentType_Get_Entities_Length_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documenttypegetentitieslength")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entityList;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  entityList = docType.getEntities();
  assertNotNull(entityList, "entitiesNotNull");
  if (("image/svg+xml".equals(getContentType()))) {
   assertTrue(equalsSize(7, entityList), "entitySizeSVG");
  } else {
   assertTrue(equalsSize(5, entityList), "entitySize");
  }
 }
}