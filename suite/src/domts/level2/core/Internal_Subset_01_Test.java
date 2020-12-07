package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getInternalSubset()" method returns 
* the internal subset as a string or null if there is none.
* This does not contain the delimiting brackets.
* 
* Retrieve the documenttype.
* Apply the "getInternalSubset()" method.  Null is returned since there 
* is not an internal subset.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-internalSubset">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-internalSubset</a>
*/
class Internal_Subset_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff2", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/internalSubset01")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  String internal;
  doc = (Document) load("staff2", false);
  docType = doc.getDoctype();
  internal = docType.getInternalSubset();
  assertNull(internal, "internalSubsetNull");
 }
}