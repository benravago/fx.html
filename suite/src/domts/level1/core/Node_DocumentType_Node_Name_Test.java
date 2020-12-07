package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the DOCTYPE declaration from the XML file and
* check the string returned by the "getNodeName()" 
* method.   It should be equal to "staff" or "svg". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
*/
@Disabled("fx")
class Node_DocumentType_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodedocumenttypenodename")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  String documentTypeName;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  documentTypeName = docType.getNodeName();
  if (("image/svg+xml".equals(getContentType()))) {
   assertEquals("svg", documentTypeName, "doctypeNameSVG");
  } else {
   assertEquals("staff", documentTypeName, "documentName");
  }
 }
}