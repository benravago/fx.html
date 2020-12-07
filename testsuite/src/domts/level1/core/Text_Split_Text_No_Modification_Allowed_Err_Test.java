package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "splitText(offset)" method raises a 
* NO_MODIFICATION_ALLOWED_ERR DOMException if the
* node is readonly.
* 
* Obtain the children of the THIRD "gender" element.   The elements
* content is an entity reference.   Get the element content of the FIRST
* Text Node of the entity reference and execute the "splitText(offset)" method.
* This causes a NO_MODIFICATION_ALLOWED_ERR DOMException to be thrown.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-38853C1D')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-38853C1D')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D</a>
*/
@Disabled("fx")
class Text_Split_Text_No_Modification_Allowed_Err_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/textsplittextnomodificationallowederr")
 void run() throws Throwable {
  Document doc;
  NodeList genderList;
  Node gender;
  Node entRef;
  Node entElement;
  Node entElementText;
  Text splitNode;
  int nodeType;
  doc = (Document) load("staff", true);
  genderList = doc.getElementsByTagName("gender");
  gender = genderList.item(2);
  entRef = gender.getFirstChild();
  assertNotNull(entRef, "entRefNotNull");
  nodeType = (int) entRef.getNodeType();
  if (equals(1, nodeType)) {
   entRef = doc.createEntityReference("ent4");
   assertNotNull(entRef, "createdEntRefNotNull");
  }
  entElement = entRef.getFirstChild();
  assertNotNull(entElement, "entElementNotNull");
  entElementText = entElement.getFirstChild();
  assertNotNull(entElementText, "entElementTextNotNull");
  {
   boolean success = false;
   try {
    splitNode = ((Text) /*Node */entElementText).splitText(2);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
  }
 }
}