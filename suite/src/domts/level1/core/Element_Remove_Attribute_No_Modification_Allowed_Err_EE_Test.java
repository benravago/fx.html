package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeAttribute(name)" method for an attribute causes the 
* DOMException NO_MODIFICATION_ALLOWED_ERR to be raised
* if the node is readonly.
* 
* Create an reference the entity ent4 and add it to the THIRD "gender" element.  
* Try to remove the "domestic" attribute from the entity reference by executing the "removeAttribute(name)" method.
* This causes a NO_MODIFICATION_ALLOWED_ERR DOMException to be thrown.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D6AC0F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D6AC0F9</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-6D6AC0F9')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-6D6AC0F9')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D6AC0F9">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6D6AC0F9</a>
* @see <a href="http://www.w3.org/2001/DOM-Test-Suite/level1/core/elementremoveattributenomodificationallowederr.xml">http://www.w3.org/2001/DOM-Test-Suite/level1/core/elementremoveattributenomodificationallowederr.xml</a>
*/
@Disabled("fx")
class Element_Remove_Attribute_No_Modification_Allowed_Err_EE_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementremoveattributenomodificationallowederrEE")
 void run() throws Throwable {
  Document doc;
  NodeList genderList;
  Node gender;
  EntityReference entRef;
  Element entElement;
  Node appendedChild;
  doc = (Document) load("staff", true);
  genderList = doc.getElementsByTagName("gender");
  gender = genderList.item(2);
  entRef = doc.createEntityReference("ent4");
  assertNotNull(entRef, "createdEntRefNotNull");
  appendedChild = gender.appendChild(entRef);
  entElement = (Element) entRef.getFirstChild();
  assertNotNull(entElement, "entElementNotNull");
  {
   boolean success = false;
   try {
    entElement.removeAttribute("domestic");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
  }
 }
}