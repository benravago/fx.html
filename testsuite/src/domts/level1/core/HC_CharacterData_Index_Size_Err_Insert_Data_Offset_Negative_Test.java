package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "insertData(offset,arg)" method raises an
* INDEX_SIZE_ERR DOMException if the specified offset
* is negative. 
* 
* Retrieve the character data of the last child of the
* first employee and invoke its insertData"(offset,arg)"
* method with offset=-5 and arg="ABC".  It should raise
* the desired exception since the offset is negative.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INDEX_SIZE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INDEX_SIZE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-E5CBA7FB">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-E5CBA7FB</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-E5CBA7FB')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-E5CBA7FB')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])</a>
*/
class HC_CharacterData_Index_Size_Err_Insert_Data_Offset_Negative_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  feature("signed");
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_characterdataindexsizeerrinsertdataoffsetnegative")
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
    child.replaceData(-5, 3, "ABC");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INDEX_SIZE_ERR);
   }
   assertTrue(success, "throws_INDEX_SIZE_ERR");
  }
 }
}