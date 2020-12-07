package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setValue()" method for an attribute causes the 
* DOMException NO_MODIFICATION_ALLOWED_ERR to be raised
* if the node is readonly.
* Obtain the children of the THIRD "gender" element.  The elements
* content is an entity reference.  Get the "domestic" attribute
* from the entity reference and execute the "setValue()" method.
* This causes a NO_MODIFICATION_ALLOWED_ERR DOMException to be thrown.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#ID-221662474">http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#ID-221662474</a>
* @see <a href="http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#xpointer(id('ID-221662474')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/2000/WD-DOM-Level-1-20000929/level-one-core#xpointer(id('ID-221662474')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/DOM/updates/REC-DOM-Level-1-19981001-errata.html">http://www.w3.org/DOM/updates/REC-DOM-Level-1-19981001-errata.html</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-221662474">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-221662474</a>
*/
@Disabled("1")
class Attr_Set_Value_No_Modification_Allowed_Err_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setExpandEntityReferences(false);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/attrsetvaluenomodificationallowederr")
 void run() throws Throwable {
  Document doc;
  NodeList genderList;
  Node gender;
  NodeList genList;
  Node gen;
  NodeList gList;
  Node g;
  NamedNodeMap attrList;
  Attr attrNode;
  doc = (Document) load("staff", true);
  genderList = doc.getElementsByTagName("gender");
  gender = genderList.item(2);
  assertNotNull(gender, "genderNotNull");
  genList = gender.getChildNodes();
  gen = genList.item(0);
  assertNotNull(gen, "genderFirstChildNotNull");
  gList = gen.getChildNodes();
  g = gList.item(0);
  assertNotNull(g, "genderFirstGrandchildNotNull");
  attrList = g.getAttributes();
  assertNotNull(attrList, "attributesNotNull");
  attrNode = (Attr) attrList.getNamedItem("domestic");
  assertNotNull(attrNode, "attrNotNull");
  {
   boolean success = false;
   try {
    attrNode.setValue("newvalue");
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