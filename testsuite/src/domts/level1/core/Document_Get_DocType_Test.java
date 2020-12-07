package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getDoctype()" method returns the Document 
* Type Declaration associated with this document.
* Retrieve the entire DOM document and invoke its 
* "getDoctype()" method.  The name of the document
* type should be returned.  The "getName()" method
* should be equal to "staff" or "svg".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A31">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A31</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=249">http://www.w3.org/Bugs/Public/show_bug.cgi?id=249</a>
*/
@Disabled("fx")
class Document_Get_DocType_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentgetdoctype")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  String docTypeName;
  String nodeValue;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  docTypeName = docType.getName();
  if (("image/svg+xml".equals(getContentType()))) {
   assertEquals("svg", docTypeName, "doctypeNameSVG");
  } else {
   assertEquals("staff", docTypeName, "doctypeName");
  }
  nodeValue = docType.getNodeValue();
  assertNull(nodeValue, "initiallyNull");
 }
}