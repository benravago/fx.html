package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setAttributeNode(newAttr)" method for an attribute causes the 
* DOMException NO_MODIFICATION_ALLOWED_ERR to be raised
* if the node is readonly.
* 
* Create an entity reference and add to the THIRD "gender" element.  The elements
* content is an entity reference.  Try to remove the "domestic" attribute
* from the entity reference by executing the "setAttributeNode(newAttr)" method.
* This causes a NO_MODIFICATION_ALLOWED_ERR DOMException to be thrown.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-887236154')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-887236154')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-887236154</a>
* @see <a href="http://www.w3.org/2001/DOM-Test-Suite/level1/core/elementsetattributenodenomodificationallowederr.xml">http://www.w3.org/2001/DOM-Test-Suite/level1/core/elementsetattributenodenomodificationallowederr.xml</a>
*/
@Disabled("1")
class Element_Set_Attribute_Node_No_Modification_Allowed_Err_EE_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setExpandEntityReferences(false);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementsetattributenodenomodificationallowederrEE")
 void run() throws Throwable {
  Document doc;
  NodeList genderList;
  Node gender;
  EntityReference entRef;
  Element entElement;
  Attr newAttr;
  Attr badAttr;
  Node appendedChild;
  doc = (Document) load("staff", true);
  genderList = doc.getElementsByTagName("gender");
  gender = genderList.item(2);
  entRef = doc.createEntityReference("ent4");
  assertNotNull(entRef, "createdEntRefNotNull");
  appendedChild = gender.appendChild(entRef);
  entElement = (Element) entRef.getFirstChild();
  assertNotNull(entElement, "entElementNotNull");
  newAttr = doc.createAttribute("newAttr");
  {
   boolean success = false;
   try {
    badAttr = entElement.setAttributeNode(newAttr);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
  }
 }
}