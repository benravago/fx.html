package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the notation named "notation1" and access its  
* system identifier.  Since a system identifier was not
* specified for this notation, the "getSystemId()" method
* should return null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-E8AAB1D0">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-E8AAB1D0</a>
*/
class Notation_Get_SystemId_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/notationgetsystemidnull")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap notations;
  Notation notationNode;
  String systemId;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  notations = docType.getNotations();
  assertNotNull(notations, "notationsNotNull");
  notationNode = (Notation) notations.getNamedItem("notation1");
  systemId = notationNode.getSystemId();
  assertNull(systemId, "systemId");
 }
}