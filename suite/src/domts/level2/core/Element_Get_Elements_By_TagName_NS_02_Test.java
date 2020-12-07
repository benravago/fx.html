package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getElementsByTagNameNS returns a NodeList of all the Elements with a given local 
* name and namespace URI in the order in which they are encountered in a preorder traversal 
* of the Document tree. 
* Invoke getElementsByTagNameNS on the documentElement with values for namespaceURI '*' and 
* localName '*'.  Verify if this returns a nodeList of 0 elements. 
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
*/
class Element_Get_Elements_By_TagName_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementgetelementsbytagnamens02")
 void run() throws Throwable {
  Document doc;
  Element element;
  NodeList elementList;
  doc = (Document) load("staffNS", false);
  element = doc.getDocumentElement();
  elementList = element.getElementsByTagNameNS("**", "*");
  assertTrue(equalsSize(0, elementList), "elementgetelementsbytagnamens02");
 }
}