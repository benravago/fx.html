package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Access Document.doctype for hc_staff, if not text/html should return DocumentType node.
* HTML implementations may return null.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A31">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-B63ED1A31</a>
*/
@Disabled("fx")
class HC_Document_Get_DocType_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_documentgetdoctype")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  String docTypeName;
  String nodeValue;
  NamedNodeMap attributes;
  doc = (Document) load("hc_staff", false);
  docType = doc.getDoctype();
  if (!(("text/html".equals(getContentType())))) {
   assertNotNull(docType, "docTypeNotNull");
  }
  if ((docType != null)) {
   docTypeName = docType.getName();
   if (("image/svg+xml".equals(getContentType()))) {
    assertEquals("svg", docTypeName, "nodeNameSVG");
   } else {
    assertEquals("html", docTypeName, "nodeName");
   }
   nodeValue = docType.getNodeValue();
   assertNull(nodeValue, "nodeValue");
   attributes = docType.getAttributes();
   assertNull(attributes, "attributes");
  }
 }
}