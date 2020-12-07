package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* An attempt to add an element to the named node map returned by notations should 
* result in a NO_MODIFICATION_ERR or HIERARCHY_REQUEST_ERR.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D46829EF">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D46829EF</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
*/
class HC_Notations_Set_NamedItem_NS_1_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/hc_notationssetnameditemns1")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap notations;
  DocumentType docType;
  Node retval;
  Element elem;
  doc = (Document) load("hc_staff", true);
  docType = doc.getDoctype();
  if (!(("text/html".equals(getContentType())))) {
   assertNotNull(docType, "docTypeNotNull");
   notations = docType.getNotations();
   assertNotNull(notations, "notationsNotNull");
   elem = doc.createElementNS("http://www.w3.org/1999/xhtml", "br");
   try {
    retval = notations.setNamedItemNS(elem);
    fail("throw_HIER_OR_NO_MOD_ERR");
   } catch (DOMException ex) {
    switch (ex.code) {
     case 3:
      break;
     case 7:
      break;
     default:
      throw ex;
    }
   }
  }
 }
}