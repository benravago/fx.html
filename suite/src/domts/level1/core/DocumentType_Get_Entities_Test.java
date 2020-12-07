package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getEntities()" method is a NamedNodeMap that contains
* the general entities for this document. 
* 
* Retrieve the Document Type for this document and create 
* a NamedNodeMap of all its entities.  The entire map is
* traversed and the names of the entities are retrieved.
* There should be 5 entities.  Duplicates should be ignored.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1788794630">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1788794630</a>
*/
@Disabled("fx")
class DocumentType_Get_Entities_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documenttypegetentities")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap entityList;
  String name;
  Collection expectedResult = new ArrayList();
  expectedResult.add("ent1");
  expectedResult.add("ent2");
  expectedResult.add("ent3");
  expectedResult.add("ent4");
  expectedResult.add("ent5");
  Collection expectedResultSVG = new ArrayList();
  expectedResultSVG.add("ent1");
  expectedResultSVG.add("ent2");
  expectedResultSVG.add("ent3");
  expectedResultSVG.add("ent4");
  expectedResultSVG.add("ent5");
  expectedResultSVG.add("svgunit");
  expectedResultSVG.add("svgtest");
  Collection nameList = new ArrayList();
  Node entity;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  entityList = docType.getEntities();
  assertNotNull(entityList, "entitiesNotNull");
  for (int indexN1007B = 0; indexN1007B < entityList.getLength(); indexN1007B++) {
   entity = (Node) entityList.item(indexN1007B);
   name = entity.getNodeName();
   nameList.add(name);
  }
  if (("image/svg+xml".equals(getContentType()))) {
   assertEquals(expectedResultSVG, nameList, "entityNamesSVG");
  } else {
   assertEquals(expectedResult, nameList, "entityNames");
  }
 }
}