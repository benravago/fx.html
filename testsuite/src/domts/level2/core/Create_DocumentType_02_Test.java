package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createDocumentType(qualifiedName,publicId,systemId)" method for a 
* DOMImplementation should raise INVALID_CHARACTER_ERR DOMException if
* qualifiedName contains an illegal character.
* 
* Invoke method createDocumentType(qualifiedName,publicId,systemId) on
* this domimplementation with qualifiedName containing an illegal character
* from illegalChars[]. Method should raise INVALID_CHARACTER_ERR
* DOMException for all characters in illegalChars[].
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType">http://www.w3.org/TR/DOM-Level-2-Core/core#Level-2-Core-DOM-createDocType</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Level-2-Core-DOM-createDocType')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('Level-2-Core-DOM-createDocType')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])</a>
*/
class Create_DocumentType_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createDocumentType02")
 void run() throws Throwable {
  String publicId = "http://www.localhost.com/";
  String systemId = "myDoc.dtd";
  String qualifiedName;
  Document doc;
  DocumentType docType = null;
  DOMImplementation domImpl;
  List illegalQNames = new ArrayList();
  illegalQNames.add("edi:{");
  illegalQNames.add("edi:}");
  illegalQNames.add("edi:~");
  illegalQNames.add("edi:'");
  illegalQNames.add("edi:!");
  illegalQNames.add("edi:@");
  illegalQNames.add("edi:#");
  illegalQNames.add("edi:$");
  illegalQNames.add("edi:%");
  illegalQNames.add("edi:^");
  illegalQNames.add("edi:&");
  illegalQNames.add("edi:*");
  illegalQNames.add("edi:(");
  illegalQNames.add("edi:)");
  illegalQNames.add("edi:+");
  illegalQNames.add("edi:=");
  illegalQNames.add("edi:[");
  illegalQNames.add("edi:]");
  illegalQNames.add("edi:\\");
  illegalQNames.add("edi:/");
  illegalQNames.add("edi:;");
  illegalQNames.add("edi:`");
  illegalQNames.add("edi:<");
  illegalQNames.add("edi:>");
  illegalQNames.add("edi:,");
  illegalQNames.add("edi:a ");
  illegalQNames.add("edi:\"");
  doc = (Document) load("staffNS", false);
  for (int indexN1009A = 0; indexN1009A < illegalQNames.size(); indexN1009A++) {
   qualifiedName = (String) illegalQNames.get(indexN1009A);
   domImpl = doc.getImplementation();
   {
    boolean success = false;
    try {
     docType = domImpl.createDocumentType(qualifiedName, publicId, systemId);
    } catch (DOMException ex) {
     success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
    }
    assertTrue(success, "throw_INVALID_CHARACTER_ERR");
   }
  }
 }
}