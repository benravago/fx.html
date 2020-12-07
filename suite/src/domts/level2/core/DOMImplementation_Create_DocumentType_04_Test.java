package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method createDocumentType should raise a INVALID_CHARACTER_ERR if the qualifiedName 
* contains an illegal characters.
* 
* Invoke createDocument on this DOMImplementation with qualifiedNames having illegal characters. 
* Check if an INVALID_CHARACTER_ERR is raised in each case.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType</a>
*/
class DOMImplementation_Create_DocumentType_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/domimplementationcreatedocumenttype04")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  DocumentType newDocType;
  String publicId = "http://www.w3.org/DOM/Test/dom2.dtd";
  String systemId = "dom2.dtd";
  String qualifiedName;
  List qualifiedNames = new ArrayList();
  qualifiedNames.add("{");
  qualifiedNames.add("}");
  qualifiedNames.add("'");
  qualifiedNames.add("~");
  qualifiedNames.add("`");
  qualifiedNames.add("@");
  qualifiedNames.add("#");
  qualifiedNames.add("$");
  qualifiedNames.add("%");
  qualifiedNames.add("^");
  qualifiedNames.add("&");
  qualifiedNames.add("*");
  qualifiedNames.add("(");
  qualifiedNames.add(")");
  doc = (Document) load("staffNS", false);
  domImpl = doc.getImplementation();
  for (int indexN10073 = 0; indexN10073 < qualifiedNames.size(); indexN10073++) {
   qualifiedName = (String) qualifiedNames.get(indexN10073);
   {
    boolean success = false;
    try {
     newDocType = domImpl.createDocumentType(qualifiedName, publicId, systemId);
    } catch (DOMException ex) {
     success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
    }
    assertTrue(success, "domimplementationcreatedocumenttype04");
   }
  }
 }
}