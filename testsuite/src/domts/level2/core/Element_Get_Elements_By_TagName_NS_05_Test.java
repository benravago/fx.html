package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Returns a NodeList of all the Elements with a given local name and namespace URI in the 
* order in which they are encountered in a preorder traversal of the Document tree. 
* Invoke getElementsByTagNameNS on the documentElement with the following values:
* namespaceURI: 'http://www.altavista.com' 
* localName: '*'.  
* Verify if this returns a nodeList of 1 elements. 
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
*/
class Element_Get_Elements_By_TagName_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementgetelementsbytagnamens05")
 void run() throws Throwable {
  Document doc;
  Element element;
  NodeList elementList;
  doc = (Document) load("staffNS", false);
  element = doc.getDocumentElement();
  elementList = element.getElementsByTagNameNS("http://www.altavista.com", "*");
  assertTrue(equalsSize(1, elementList), "elementgetelementsbytagnamens05");
 }
}