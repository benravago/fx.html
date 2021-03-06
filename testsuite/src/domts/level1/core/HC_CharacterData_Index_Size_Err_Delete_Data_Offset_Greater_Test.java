package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "deleteData(offset,count)" method raises an
* INDEX_SIZE_ERR DOMException if the specified offset
* is greater that the number of characters in the string. 
* 
* Retrieve the character data of the last child of the
* first employee and invoke its "deleteData(offset,count)"
* method with offset=40 and count=3.  It should raise the
* desired exception since the offset is greater than the
* number of characters in the string.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INDEX_SIZE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INDEX_SIZE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7C603781">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7C603781</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-7C603781')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-7C603781')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7C603781">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-7C603781</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=249">http://www.w3.org/Bugs/Public/show_bug.cgi?id=249</a>
*/
class HC_CharacterData_Index_Size_Err_Delete_Data_Offset_Greater_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_characterdataindexsizeerrdeletedataoffsetgreater")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  CharacterData child;
  doc = (Document) load("hc_staff", true);
  elementList = doc.getElementsByTagName("acronym");
  nameNode = elementList.item(0);
  child = (CharacterData) nameNode.getFirstChild();
  {
   boolean success = false;
   try {
    child.deleteData(40, 3);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INDEX_SIZE_ERR);
   }
   assertTrue(success, "throw_INDEX_SIZE_ERR");
  }
 }
}