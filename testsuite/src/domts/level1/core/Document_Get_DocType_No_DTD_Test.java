package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getDoctype()" method returns null for XML documents
* without a document type declaration.
* Retrieve the XML document without a DTD and invoke the 
* "getDoctype()" method.  It should return null. 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A31">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A31</a>
*/
class Document_Get_DocType_No_DTD_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setValidating(false);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_nodtdstaff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentgetdoctypenodtd")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  doc = (Document) load("hc_nodtdstaff", false);
  docType = doc.getDoctype();
  assertNull(docType, "documentGetDocTypeNoDTDAssert");
 }
}