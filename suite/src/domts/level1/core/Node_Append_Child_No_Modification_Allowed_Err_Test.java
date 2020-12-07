package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "appendChild(newChild)" method causes the 
* DOMException NO_MODIFICATION_ALLOWED_ERR to be raised
* if the node is readonly.
* 
* Obtain the children of the THIRD "gender" element.   The elements
* content is an entity reference.   Get the FIRST item 
* from the entity reference and execute the "appendChild(newChild)" method.
* This causes a NO_MODIFICATION_ALLOWED_ERR DOMException to be thrown.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-184E7107')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-184E7107')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-184E7107</a>
*/
@Disabled("fx")
class Node_Append_Child_No_Modification_Allowed_Err_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeappendchildnomodificationallowederr")
 void run() throws Throwable {
  Document doc;
  NodeList genderList;
  Node genderNode;
  Node entRef;
  Node entElement;
  Node createdNode;
  Node appendedNode;
  int nodeType;
  doc = (Document) load("staff", true);
  genderList = doc.getElementsByTagName("gender");
  genderNode = genderList.item(2);
  entRef = genderNode.getFirstChild();
  assertNotNull(entRef, "entRefNotNull");
  nodeType = (int) entRef.getNodeType();
  if (equals(1, nodeType)) {
   entRef = doc.createEntityReference("ent4");
   assertNotNull(entRef, "createdEntRefNotNull");
  }
  entElement = entRef.getFirstChild();
  assertNotNull(entElement, "entElementNotNull");
  createdNode = doc.createElement("text3");
  {
   boolean success = false;
   try {
    appendedNode = entElement.appendChild(createdNode);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
  }
 }
}