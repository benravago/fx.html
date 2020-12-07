package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Notation nodes are not namespaced and should not be retrievable using
* getNamedItemNS.
* @author Curt Arnold
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
@Disabled("2")
class Get_NamedItem_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getNamedItemNS04")
 void run() throws Throwable {
  Document doc;
  DocumentType docType;
  NamedNodeMap notations;
  Notation notation;
  String nullNS = null;
  doc = (Document) load("staffNS", false);
  docType = doc.getDoctype();
  notations = docType.getNotations();
  assertNotNull(notations, "notationsNotNull");
  notation = (Notation) notations.getNamedItemNS(nullNS, "notation1");
  assertNull(notation, "notationNull");
 }
}