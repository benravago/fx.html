package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagNameNS(namespaceURI,localName)" method returns a NodeList
* of all descendant Elements with a given local name and namespace URI in the
* order in which they are encountered in a preorder traversal of this Element tree.
* 
* Create a NodeList of all the descendant elements
* using the "http://www.nomatch.com" as the namespaceURI and "address" as the 
* localName.
* The method should return a NodeList whose length is
* "0".  
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
*/
class Get_Elements_By_TagName_NS_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getElementsByTagNameNS06")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagNameNS("http://www.nomatch.com", "address");
  assertTrue(equalsSize(0, elementList), "matchSize");
 }
}