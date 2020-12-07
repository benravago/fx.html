package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setAttributeNS adds a new attribute and raises a INVALID_CHARACTER_ERR if 
* the specified qualified name contains an illegal character.
* Invoke the setAttributeNS method on this Element object with a valid value for 
* namespaceURI, and qualifiedNames that contain illegal characters.  Check if the an
* INVALID_CHARACTER_ERR was thrown.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
*/
class Element_Set_Attribute_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributens04")
 void run() throws Throwable {
  Document doc;
  Element element;
  String qualifiedName;
  List qualifiedNames = new ArrayList();
  qualifiedNames.add("/");
  qualifiedNames.add("//");
  qualifiedNames.add("\\");
  qualifiedNames.add(";");
  qualifiedNames.add("&");
  qualifiedNames.add("*");
  qualifiedNames.add("]]");
  qualifiedNames.add(">");
  qualifiedNames.add("<");
  doc = (Document) load("staffNS", true);
  element = doc.createElementNS("http://www.w3.org/DOM/Test/L2", "dom:elem");
  for (int indexN10058 = 0; indexN10058 < qualifiedNames.size(); indexN10058++) {
   qualifiedName = (String) qualifiedNames.get(indexN10058);
   {
    boolean success = false;
    try {
     element.setAttributeNS("http://www.w3.org/DOM/Test/L2", qualifiedName, "test");
    } catch (DOMException ex) {
     success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
    }
    assertTrue(success, "elementsetattributens04");
   }
  }
 }
}