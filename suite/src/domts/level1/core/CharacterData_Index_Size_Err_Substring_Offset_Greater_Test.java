package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "substringData(offset,count)" method raises an
* INDEX_SIZE_ERR DOMException if the specified offset
* is greater than the number of characters in the string.
* 
* Retrieve the character data of the last child of the
* first employee and invoke its "substringData(offset,count)
* method with offset=40 and count=3.  It should raise the
* desired exception since the offsets value is greater
* than the length.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INDEX_SIZE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INDEX_SIZE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6531BCCF">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-6531BCCF</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-6531BCCF')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-6531BCCF')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=249">http://www.w3.org/Bugs/Public/show_bug.cgi?id=249</a>
*/
class CharacterData_Index_Size_Err_Substring_Offset_Greater_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/characterdataindexsizeerrsubstringoffsetgreater")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  CharacterData child;
  String badString;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  nameNode = elementList.item(0);
  child = (CharacterData) nameNode.getFirstChild();
  {
   boolean success = false;
   try {
    badString = child.substringData(40, 3);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INDEX_SIZE_ERR);
   }
   assertTrue(success, "throw_INDEX_SIZE_ERR");
  }
 }
}