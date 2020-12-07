package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Attempt to append a text node from another document to an attribute which should result
* in a WRONG_DOCUMENT_ERR.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-952280727</a>
*/
class HC_Attr_Insert_Before_6_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_attrinsertbefore6")
 void run() throws Throwable {
  Document doc;
  NodeList acronymList;
  Node testNode;
  NamedNodeMap attributes;
  Attr titleAttr;
  String value;
  Node textNode;
  Node retval;
  Node refChild = null;
  Document otherDoc;
  doc = (Document) load("hc_staff", true);
  otherDoc = (Document) load("hc_staff", true);
  acronymList = doc.getElementsByTagName("acronym");
  testNode = acronymList.item(3);
  attributes = testNode.getAttributes();
  titleAttr = (Attr) attributes.getNamedItem("title");
  textNode = otherDoc.createTextNode("terday");
  {
   boolean success = false;
   try {
    retval = titleAttr.insertBefore(textNode, refChild);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.WRONG_DOCUMENT_ERR);
   }
   assertTrue(success, "throw_WRONG_DOCUMENT_ERR");
  }
 }
}