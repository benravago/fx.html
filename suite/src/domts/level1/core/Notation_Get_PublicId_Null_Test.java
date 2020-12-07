package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getPublicId()" method of a Notation node contains
* the public identifier associated with the notation, if
* one was not specified a null value should be returned.
* 
* Retrieve the notation named "notation2" and access its  
* public identifier.  Since a public identifier was not
* specified for this notation, the "getPublicId()" method
* should return null.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-54F2B4D0">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-54F2B4D0</a>
*/
class Notation_Get_PublicId_Null_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/notationgetpublicidnull")
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
  notationNode = (Notation) notations.getNamedItem("notation2");
  publicId = notationNode.getPublicId();
  assertNull(publicId, "publicId");
 }
}