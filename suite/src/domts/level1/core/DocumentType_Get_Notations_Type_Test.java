package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Every node in the map returned by the "getNotations()"
* method implements the Notation interface.
* 
* Retrieve the Document Type for this document and create
* a NamedNodeMap object of all the notations.  Traverse
* the entire list and examine the NodeType of each node.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D46829EF">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D46829EF</a>
*/
class DocumentType_Get_Notations_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documenttypegetnotationstype")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap notationList;
  Node notation;
  int notationType;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  notationList = docType.getNotations();
  assertNotNull(notationList, "notationsNotNull");
  for (int indexN10049 = 0; indexN10049 < notationList.getLength(); indexN10049++) {
   notation = (Node) notationList.item(indexN10049);
   notationType = (int) notation.getNodeType();
   assertEquals(12, notationType, "documenttypeGetNotationsTypeAssert");
  }
 }
}