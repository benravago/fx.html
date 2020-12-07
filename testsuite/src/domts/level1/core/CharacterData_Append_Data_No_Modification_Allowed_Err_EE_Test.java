package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Create an ent3 entity reference and call appendData on a text child, should thrown a NO_MODIFICATION_ALLOWED_ERR. 
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-32791A2F">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-32791A2F</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-32791A2F')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-32791A2F')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NO_MODIFICATION_ALLOWED_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-32791A2F">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-32791A2F</a>
* @see <a href="http://www.w3.org/2001/DOM-Test-Suite/level1/core/characterdataappenddatanomodificationallowederr.xml">http://www.w3.org/2001/DOM-Test-Suite/level1/core/characterdataappenddatanomodificationallowederr.xml</a>
*/
@Disabled("1")
class CharacterData_Append_Data_No_Modification_Allowed_Err_EE_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/characterdataappenddatanomodificationallowederrEE")
 void run() throws Throwable {
  Document doc;
  NodeList genderList;
  Node genderNode;
  Node entText;
  EntityReference entReference;
  Node appendedChild;
  doc = (Document) load("staff", true);
  genderList = doc.getElementsByTagName("gender");
  genderNode = genderList.item(2);
  entReference = doc.createEntityReference("ent3");
  assertNotNull(entReference, "createdEntRefNotNull");
  appendedChild = genderNode.appendChild(entReference);
  entText = entReference.getFirstChild();
  assertNotNull(entText, "entTextNotNull");
  {
   boolean success = false;
   try {
    ((CharacterData) /*Node */entText).appendData("newString");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NO_MODIFICATION_ALLOWED_ERR);
   }
   assertTrue(success, "throw_NO_MODIFICATION_ALLOWED_ERR");
  }
 }
}