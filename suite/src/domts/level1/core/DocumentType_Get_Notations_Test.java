package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNotations()" method creates a NamedNodeMap that   
* contains all the notations declared in the DTD.
* 
* Retrieve the Document Type for this document and create
* a NamedNodeMap object of all the notations.  There
* should be two items in the list (notation1 and notation2).
* @author NIST
* @author Mary Brady
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D46829EF">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D46829EF</a>
*/
class DocumentType_Get_Notations_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documenttypegetnotations")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap notationList;
  Node notation;
  String notationName;
  Collection actual = new ArrayList();
  Collection expected = new ArrayList();
  expected.add("notation1");
  expected.add("notation2");
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  notationList = docType.getNotations();
  assertNotNull(notationList, "notationsNotNull");
  for (int indexN1005B = 0; indexN1005B < notationList.getLength(); indexN1005B++) {
   notation = (Node) notationList.item(indexN1005B);
   notationName = notation.getNodeName();
   actual.add(notationName);
  }
  assertEquals(expected, actual, "names");
 }
}