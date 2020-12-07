package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setData(data)" method for a processing instruction causes the 
* DOMException NO_MODIFICATION_ALLOWED_ERR to be raised
* if the node is readonly.
* 
* Create an ent4 entity reference and add to document of the THIRD "gender" element.  The elements
* content is an entity reference.  Try to remove the "domestic" attribute
* from the entity reference by executing the "setData(data)" method.
* This causes a NO_MODIFICATION_ALLOWED_ERR DOMException to be thrown.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-837822393">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-837822393</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-837822393')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-837822393')/setraises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-837822393">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-837822393</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2002Apr/0053.html">http://lists.w3.org/Archives/Public/www-dom-ts/2002Apr/0053.html</a>
* @see <a href="http://www.w3.org/2001/DOM-Test-Suite/level1/core/processinginstructionsetdatanomodificationallowederr.xml">http://www.w3.org/2001/DOM-Test-Suite/level1/core/processinginstructionsetdatanomodificationallowederr.xml</a>
*/
@Disabled("fx")
class ProcessingInstruction_Set_Data_No_Modification_Allowed_Err_EE_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/processinginstructionsetdatanomodificationallowederrEE")
 void run() throws Throwable {
  Document doc;
  NodeList genderList;
  Node gender;
  Node entRef;
  ProcessingInstruction piNode;
  Node appendedChild;
  doc = (Document) load("staff", true);
  genderList = doc.getElementsByTagName("gender");
  gender = genderList.item(2);
  entRef = doc.createEntityReference("ent4");
  appendedChild = gender.appendChild(entRef);
  entRef = gender.getLastChild();
  assertNotNull(entRef, "entRefNotNull");
  piNode = (ProcessingInstruction) entRef.getLastChild();
  assertNotNull(piNode, "piNodeNotNull");
  {
   boolean success = false;
   try {
    piNode.setData("newData");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
  }
 }
}