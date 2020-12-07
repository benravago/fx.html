package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Create a NamedNodeMap object from the attributes of the
* last child of the third "p" element and traverse the
* list from index 0 thru length -1.  All indices should
* be valid.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-84CF096</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-349467F9</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D0FB19E">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D0FB19E</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=250">http://www.w3.org/Bugs/Public/show_bug.cgi?id=250</a>
*/
class HC_NamedNodeMap_Child_Node_Range_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_namednodemapchildnoderange")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node testEmployee;
  NamedNodeMap attributes;
  Node child;
  String strong;
  int length;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("acronym");
  testEmployee = elementList.item(2);
  attributes = testEmployee.getAttributes();
  length = (int) attributes.getLength();
  if (("text/html".equals(getContentType()))) {
   assertEquals(2, length, "htmlLength");
  } else {
   assertEquals(3, length, "length");
   child = attributes.item(2);
   assertNotNull(child, "attr2");
  }
  child = attributes.item(0);
  assertNotNull(child, "attr0");
  child = attributes.item(1);
  assertNotNull(child, "attr1");
  child = attributes.item(3);
  assertNull(child, "attr3");
 }
}