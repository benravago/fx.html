package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getSystemId()" method of a documenttype node contains
* the system identifier associated with the external subset.
* 
* Retrieve the documenttype.
* Apply the "getSystemId()" method.  The string "staffNS.dtd" should be
* returned.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-systemId">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-systemId</a>
*/
@Disabled("2")
class SystemId_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/systemId01")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  String systemId;
  int index;
  doc = (Document) load("staffNS", false);
  docType = doc.getDoctype();
  systemId = docType.getSystemId();
  assertTrue(equalsURI(null, null, null, "staffNS.dtd", null, null, null, null, systemId), "systemId");
 }
}