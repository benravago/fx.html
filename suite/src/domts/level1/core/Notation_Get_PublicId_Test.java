package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the notation named "notation1" and access its  
* public identifier.  The string "notation1File" should be
* returned.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-54F2B4D0">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-54F2B4D0</a>
*/
class Notation_Get_PublicId_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/notationgetpublicid")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap notations;
  Notation notationNode;
  String publicId;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  notations = docType.getNotations();
  assertNotNull(notations, "notationsNotNull");
  notationNode = (Notation) notations.getNamedItem("notation1");
  publicId = notationNode.getPublicId();
  assertEquals("notation1File", publicId, "publicId");
 }
}