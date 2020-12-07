package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Attempt to append a CDATASection to an attribute which should result
* in a HIERARCHY_REQUEST_ERR.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-637646024</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107</a>
*/
class HC_Attr_Append_Child_4_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  feature("XML");
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_attrappendchild4")
 void run() throws Throwable {
  Document doc;
  NodeList acronymList;
  Node testNode;
  NamedNodeMap attributes;
  Attr titleAttr;
  String value;
  Node textNode;
  Node retval;
  Node lastChild;
  doc = (Document) load("hc_staff", true);
  acronymList = doc.getElementsByTagName("acronym");
  testNode = acronymList.item(3);
  attributes = testNode.getAttributes();
  titleAttr = (Attr) attributes.getNamedItem("title");
  if (("text/html".equals(getContentType()))) {
   {
    boolean success = false;
    try {
     textNode = doc.createCDATASection("terday");
    } catch (DOMException ex) {
     success = (ex.code == DOMException.NOT_SUPPORTED_ERR);
    }
    assertTrue(success, "throw_NOT_SUPPORTED_ERR");
   }
  } else {
   textNode = doc.createCDATASection("terday");
   {
    boolean success = false;
    try {
     retval = titleAttr.appendChild(textNode);
    } catch (DOMException ex) {
     success = (ex.code == DOMException.HIERARCHY_REQUEST_ERR);
    }
    assertTrue(success, "throw_HIERARCHY_REQUEST_ERR");
   }
  }
 }
}