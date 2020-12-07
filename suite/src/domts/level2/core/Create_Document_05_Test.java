package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createDocument(namespaceURI,qualifiedName,doctype)" method for a 
* DOMImplementation should raise INVALID_CHARACTER_ERR DOMException
* if parameter qualifiedName contains an illegal character.
* 
* Invoke method createDocument(namespaceURI,qualifiedName,doctype) on
* this domimplementation with namespaceURI equals "http://www.ecommerce.org/schema",
* doctype is null and qualifiedName contains an illegal character from
* illegalChars[].  Method should raise INVALID_CHARACTER_ERR DOMException
* for all characters in illegalChars[].
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#">http://www.w3.org/TR/DOM-Level-2-Core/core#</a>
*/
class Create_Document_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createDocument05")
 void run() throws Throwable {
  String namespaceURI = "http://www.ecommerce.org/schema";
  String qualifiedName;
  Document doc;
  DocumentType docType = null;
  DOMImplementation domImpl;
  Document aNewDoc;
  String charact;
  List illegalQNames = new ArrayList();
  illegalQNames.add("namespaceURI:{");
  illegalQNames.add("namespaceURI:}");
  illegalQNames.add("namespaceURI:~");
  illegalQNames.add("namespaceURI:'");
  illegalQNames.add("namespaceURI:!");
  illegalQNames.add("namespaceURI:@");
  illegalQNames.add("namespaceURI:#");
  illegalQNames.add("namespaceURI:$");
  illegalQNames.add("namespaceURI:%");
  illegalQNames.add("namespaceURI:^");
  illegalQNames.add("namespaceURI:&");
  illegalQNames.add("namespaceURI:*");
  illegalQNames.add("namespaceURI:(");
  illegalQNames.add("namespaceURI:)");
  illegalQNames.add("namespaceURI:+");
  illegalQNames.add("namespaceURI:=");
  illegalQNames.add("namespaceURI:[");
  illegalQNames.add("namespaceURI:]");
  illegalQNames.add("namespaceURI:\\");
  illegalQNames.add("namespaceURI:/");
  illegalQNames.add("namespaceURI:;");
  illegalQNames.add("namespaceURI:`");
  illegalQNames.add("namespaceURI:<");
  illegalQNames.add("namespaceURI:>");
  illegalQNames.add("namespaceURI:,");
  illegalQNames.add("namespaceURI:a ");
  illegalQNames.add("namespaceURI:\"");
  doc = (Document) load("staffNS", false);
  for (int indexN1009A = 0; indexN1009A < illegalQNames.size(); indexN1009A++) {
   qualifiedName = (String) illegalQNames.get(indexN1009A);
   domImpl = doc.getImplementation();
   {
    boolean success = false;
    try {
     aNewDoc = domImpl.createDocument(namespaceURI, qualifiedName, docType);
    } catch (DOMException ex) {
     success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
    }
    assertTrue(success, "throw_INVALID_CHARACTER_ERR");
   }
  }
 }
}