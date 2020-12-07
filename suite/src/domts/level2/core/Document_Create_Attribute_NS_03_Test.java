package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method createAttributeNS raises an INVALID_CHARACTER_ERR if the specified 
* qualified name contains an illegal character
* 
* Invoke the createAttributeNS method on this Document object with a valid value for 
* namespaceURI, and qualifiedNames that contain illegal characters.  Check if the an
* INVALID_CHARACTER_ERR was thrown.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS</a>
*/
class Document_Create_Attribute_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentcreateattributeNS03")
 void run() throws Throwable {
  Document doc;
  Attr attribute;
  String namespaceURI = "http://www.w3.org/DOM/Test/Level2";
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
  doc = (Document) load("staffNS", false);
  for (int indexN1005A = 0; indexN1005A < qualifiedNames.size(); indexN1005A++) {
   qualifiedName = (String) qualifiedNames.get(indexN1005A);
   {
    boolean success = false;
    try {
     attribute = doc.createAttributeNS(namespaceURI, qualifiedName);
    } catch (DOMException ex) {
     success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
    }
    assertTrue(success, "documentcreateattributeNS03");
   }
  }
 }
}