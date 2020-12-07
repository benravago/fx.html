package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getElementsByTagNameNS(namespaceURI,localName)" method for a 
* Document should return a new NodeList of all Elements that have a namespace
* when local name is specified as ' '.
* 
* Invoke method getElementsByTagNameNS(namespaceURI,localName) on this document
* with namespaceURI and localName as " ".
* Method should return a new NodeList of 37 elements.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getElBTNNS</a>
*/
class Get_Elements_By_TagName_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/getElementsByTagNameNS01")
 void run() throws Throwable {
  String namespaceURI = "*";
  String localName = "*";
  Document doc;
  NodeList newList;
  doc = (Document) load("staffNS", false);
  newList = doc.getElementsByTagNameNS(namespaceURI, localName);
  assertTrue(equalsSize(37, newList), "throw_Size");
 }
}