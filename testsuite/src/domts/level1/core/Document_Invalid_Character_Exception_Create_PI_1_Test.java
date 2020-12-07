package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Creating a processing instruction with an empty target should cause an INVALID_CHARACTER_ERR.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-258A00AF')/constant[@name='INVALID_CHARACTER_ERR'])</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-135944439">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-135944439</a>
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-135944439')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#xpointer(id('ID-135944439')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=525">http://www.w3.org/Bugs/Public/show_bug.cgi?id=525</a>
*/
class Document_Invalid_Character_Exception_Create_PI_1_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  feature("XML");
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/documentinvalidcharacterexceptioncreatepi1")
 void run() throws Throwable {
  Document doc;
  ProcessingInstruction badPI;
  doc = (Document) load("hc_staff", true);
  if (("text/html".equals(getContentType()))) {
   {
    boolean success = false;
    try {
     badPI = doc.createProcessingInstruction("foo", "data");
    } catch (DOMException ex) {
     success = (ex.code == DOMException.NOT_SUPPORTED_ERR);
    }
    assertTrue(success, "throw_NOT_SUPPORTED_ERR");
   }
  } else {
   {
    boolean success = false;
    try {
     badPI = doc.createProcessingInstruction("", "data");
    } catch (DOMException ex) {
     success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
    }
    assertTrue(success, "throw_INVALID_CHARACTER_ERR");
   }
  }
 }
}