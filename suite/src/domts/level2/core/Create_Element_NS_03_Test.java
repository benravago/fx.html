package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createElementNS(namespaceURI,qualifiedName)" method for a 
* Document should raise INVALID_CHARACTER_ERR DOMException if 
* qualifiedName contains an illegal character.
* 
* Invoke method createElementNS(namespaceURI,qualifiedName) on this document
* with qualifiedName containing an illegal character from illegalChars[].
* Method should raise INVALID_CHARACTER_ERR DOMException for all characters
* in illegalChars[].
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrElNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrElNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-DocCrElNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-DocCrElNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])</a>
*/
class Create_Element_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createElementNS03")
 void run() throws Throwable {
  String namespaceURI = "http://www.wedding.com/";
  String qualifiedName;
  Document doc;
  boolean done;
  Element newElement;
  String charact;
  List illegalQNames = new ArrayList();
  illegalQNames.add("person:{");
  illegalQNames.add("person:}");
  illegalQNames.add("person:~");
  illegalQNames.add("person:'");
  illegalQNames.add("person:!");
  illegalQNames.add("person:@");
  illegalQNames.add("person:#");
  illegalQNames.add("person:$");
  illegalQNames.add("person:%");
  illegalQNames.add("person:^");
  illegalQNames.add("person:&");
  illegalQNames.add("person:*");
  illegalQNames.add("person:(");
  illegalQNames.add("person:)");
  illegalQNames.add("person:+");
  illegalQNames.add("person:=");
  illegalQNames.add("person:[");
  illegalQNames.add("person:]");
  illegalQNames.add("person:\\");
  illegalQNames.add("person:/");
  illegalQNames.add("person:;");
  illegalQNames.add("person:`");
  illegalQNames.add("person:<");
  illegalQNames.add("person:>");
  illegalQNames.add("person:,");
  illegalQNames.add("person:a ");
  illegalQNames.add("person:\"");
  doc = (Document) load("staffNS", false);
  for (int indexN10098 = 0; indexN10098 < illegalQNames.size(); indexN10098++) {
   qualifiedName = (String) illegalQNames.get(indexN10098);
   {
    boolean success = false;
    try {
     newElement = doc.createElementNS(namespaceURI, qualifiedName);
    } catch (DOMException ex) {
     success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
    }
    assertTrue(success, "throw_INVALID_CHARACTER_ERR");
   }
  }
 }
}