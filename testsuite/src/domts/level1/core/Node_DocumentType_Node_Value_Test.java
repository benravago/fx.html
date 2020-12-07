package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeValue()" method for a 
* DocumentType Node is null.
* @author NIST
* @author Mary Brady
*/
class Node_DocumentType_Node_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodedocumenttypenodevalue")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap attrList;
  doc = (Document) load("staff", false);
  docType = doc.getDoctype();
  assertNotNull(docType, "docTypeNotNull");
  attrList = docType.getAttributes();
  assertNull(attrList, "doctypeAttributesNull");
 }
}