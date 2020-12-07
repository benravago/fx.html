package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Attempt to insert an element into an attribute list,
* should raise a HIERARCHY_REQUEST_ERR.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='HIERARCHY_REQUEST_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='HIERARCHY_REQUEST_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1025163788</a>
* @see <a href="http://www.w3.org/2000/11/DOM-Level-2-errata#core-4">http://www.w3.org/2000/11/DOM-Level-2-errata#core-4</a>
*/
class HC_NamedNodeMap_Invalid_Type_1_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/hc_namednodemapinvalidtype1")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Element docElem;
  Element newElem;
  Node retval;
  doc = (Document) load("hc_staff", true);
  docElem = doc.getDocumentElement();
  attributes = docElem.getAttributes();
  newElem = doc.createElement("html");
  {
   boolean success = false;
   try {
    retval = attributes.setNamedItem(newElem);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.HIERARCHY_REQUEST_ERR);
   }
   assertTrue(success, "throw_HIERARCHY_REQUEST_ERR");
  }
 }
}