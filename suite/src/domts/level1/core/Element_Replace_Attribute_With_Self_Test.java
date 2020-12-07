package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* This test calls setAttributeNode to replace an attribute with itself.  
* Since the node is not an attribute of another Element, it would
* be inappropriate to throw an INUSE_ATTRIBUTE_ERR.
* This test was derived from elementinuserattributeerr which
* inadvertanly made this test.
* @author Curt Arnold
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154</a>
*/
class Element_Replace_Attribute_With_Self_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementreplaceattributewithself")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Attr streetAttr;
  Attr replacedAttr;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = (Element) elementList.item(2);
  streetAttr = testEmployee.getAttributeNode("street");
  replacedAttr = testEmployee.setAttributeNode(streetAttr);
  assertSame(streetAttr, replacedAttr, "replacedAttr");
 }
}