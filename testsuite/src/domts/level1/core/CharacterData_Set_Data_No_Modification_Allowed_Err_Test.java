package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setData(data)" method raises a NO_MODIFICATION_ALLOWED_ERR 
* DOMException if the node is readonly.
* Obtain the children of the THIRD "gender" element.  The elements
* content is an entity reference.  Get the FIRST item 
* from the entity reference and execute the "setData(data)" method.
* This causes a NO_MODIFICATION_ALLOWED_ERR DOMException to be thrown.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-72AB8359')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-72AB8359')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-72AB8359</a>
*/
@Disabled("fx")
class CharacterData_Set_Data_No_Modification_Allowed_Err_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/characterdatasetdatanomodificationallowederr")
 void run() throws Throwable {
  Document doc;
  NodeList genderList;
  Node genderNode;
  Node entElement;
  Node entElementContent;
  Node entReference;
  int nodeType;
  doc = (Document) load("staff", true);
  genderList = doc.getElementsByTagName("gender");
  genderNode = genderList.item(2);
  entReference = genderNode.getFirstChild();
  assertNotNull(entReference, "entReferenceNotNull");
  nodeType = (int) entReference.getNodeType();
  if (equals(1, nodeType)) {
   entReference = doc.createEntityReference("ent4");
   assertNotNull(entReference, "createdEntRefNotNull");
  }
  entElement = entReference.getFirstChild();
  assertNotNull(entElement, "entElementNotNull");
  entElementContent = entElement.getFirstChild();
  assertNotNull(entElementContent, "entElementContentNotNull");
  {
   boolean success = false;
   try {
    ((CharacterData) /*Node */entElementContent).setData("newData");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
  }
 }
}