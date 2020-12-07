package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "splitText(offset)" method raises an
* INDEX_SIZE_ERR DOMException if the specified offset is
* greater than the number of characters in the Text node.
* 
* Retrieve the textual data from the second child of the 
* third employee and invoke the "splitText(offset)" method.
* The desired exception should be raised since the offset
* is a greater than the number of characters in the Text
* node.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INDEX_SIZE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INDEX_SIZE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-38853C1D</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-38853C1D')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-38853C1D')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INDEX_SIZE_ERR'])</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=249">http://www.w3.org/Bugs/Public/show_bug.cgi?id=249</a>
*/
class Text_Index_Size_Err_Offset_Out_Of_Bounds_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/textindexsizeerroffsetoutofbounds")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Node nameNode;
  Text textNode;
  Text splitNode;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("name");
  nameNode = elementList.item(2);
  textNode = (Text) nameNode.getFirstChild();
  {
   boolean success = false;
   try {
    splitNode = textNode.splitText(300);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INDEX_SIZE_ERR);
   }
   assertTrue(success, "throw_INDEX_SIZE_ERR");
  }
 }
}