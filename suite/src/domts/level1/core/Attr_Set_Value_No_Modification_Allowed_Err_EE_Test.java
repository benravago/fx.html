package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setValue()" method for an attribute causes the 
* DOMException NO_MODIFICATION_ALLOWED_ERR to be raised
* if the node is readonly.
* Create an entity reference using document.createEntityReference()
* Get the "domestic" attribute from the entity 
* reference and execute the "setValue()" method.
* This causes a NO_MODIFICATION_ALLOWED_ERR DOMException to be thrown.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#ID-221662474">http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#ID-221662474</a>
* @see <a href="http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#xpointer(id('ID-221662474')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#xpointer(id('ID-221662474')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/DOM/updates/REC-DOM-Level-1-19981001-errata.html">http://www.w3.org/DOM/updates/REC-DOM-Level-1-19981001-errata.html</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-221662474">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-221662474</a>
* @see <a href="http://www.w3.org/2001/DOM-Test-Suite/level1/core/attrsetvaluenomodificationallowederr.xml">http://www.w3.org/2001/DOM-Test-Suite/level1/core/attrsetvaluenomodificationallowederr.xml</a>
*/
@Disabled("fx")
class Attr_Set_Value_No_Modification_Allowed_Err_EE_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/attrsetvaluenomodificationallowederrEE")
 void run() throws Throwable {
  Document doc;
  EntityReference entRef;
  Element entElement;
  NamedNodeMap attrList;
  Node attrNode;
  Node gender;
  NodeList genderList;
  Node appendedChild;
  doc = (Document) load("staff", true);
  genderList = doc.getElementsByTagName("gender");
  gender = genderList.item(2);
  assertNotNull(gender, "genderNotNull");
  entRef = doc.createEntityReference("ent4");
  assertNotNull(entRef, "entRefNotNull");
  appendedChild = gender.appendChild(entRef);
  entElement = (Element) entRef.getFirstChild();
  assertNotNull(entElement, "entElementNotNull");
  attrList = entElement.getAttributes();
  attrNode = attrList.getNamedItem("domestic");
  {
   boolean success = false;
   try {
    ((Attr) /*Node */attrNode).setValue("newvalue");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "setValue_throws_NO_MODIFICATION");
  }
  {
   boolean success = false;
   try {
    attrNode.setNodeValue("newvalue2");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "setNodeValue_throws_NO_MODIFICATION");
  }
 }
}