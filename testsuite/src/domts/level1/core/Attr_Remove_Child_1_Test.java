package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Removing a child node from an attribute in an entity reference
* should result in an NO_MODIFICATION_ALLOWED_ERR DOMException.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1734834066">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-1734834066</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-1734834066')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-1734834066')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
*/
@Disabled("fx")
class Attr_Remove_Child_1_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/attrremovechild1")
 void run() throws Throwable {
  Document doc;
  EntityReference entRef;
  Element entElement;
  Node attrNode;
  Text textNode;
  Node removedNode;
  doc = (Document) load("staff", true);
  entRef = doc.createEntityReference("ent4");
  assertNotNull(entRef, "createdEntRefNotNull");
  entElement = (Element) entRef.getFirstChild();
  assertNotNull(entElement, "entElementNotNull");
  attrNode = entElement.getAttributeNode("domestic");
  textNode = (Text) attrNode.getFirstChild();
  assertNotNull(textNode, "attrChildNotNull");
  {
   boolean success = false;
   try {
    removedNode = attrNode.removeChild(textNode);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "setValue_throws_NO_MODIFICATION_ERR");
  }
 }
}