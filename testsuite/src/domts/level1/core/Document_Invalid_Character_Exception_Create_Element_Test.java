package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createElement(tagName)" method raises an
* INVALID_CHARACTER_ERR DOMException if the specified
* tagName contains an invalid character. 
* 
* Retrieve the entire DOM document and invoke its 
* "createElement(tagName)" method with the tagName equal
* to the string "invalid^Name".  Due to the invalid 
* character the desired EXCEPTION should be raised.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INVALID_CHARACTER_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-2141741547')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-2141741547')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-2141741547</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=249">http://www.w3.org/Bugs/Public/show_bug.cgi?id=249</a>
*/
class Document_Invalid_Character_Exception_Create_Element_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentinvalidcharacterexceptioncreateelement")
 void run() throws Throwable {
  Document doc;
  Element badElement;
  doc = (Document) load("staff", true);
  {
   boolean success = false;
   try {
    badElement = doc.createElement("invalid^Name");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
   }
   assertTrue(success, "throw_INVALID_CHARACTER_ERR");
  }
 }
}