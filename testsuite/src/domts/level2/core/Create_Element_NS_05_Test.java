package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createElementNS(namespaceURI,qualifiedName)" method for a 
* Document should return a new Element object given that all parameters
* are valid and correctly formed.
* 
* Invoke method createElementNS(namespaceURI,qualifiedName on this document
* with namespaceURI as "http://www.nist.gov" and qualifiedName as "gov:faculty".
* Method should return a new Element object whose name is "gov:faculty".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-104682815">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-104682815</a>
*/
class Create_Element_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createElementNS05")
 void run() throws Throwable {
  String namespaceURI = "http://www.nist.gov";
  String qualifiedName = "gov:faculty";
  Document doc;
  Element newElement;
  String elementName;
  doc = (Document) load("staffNS", false);
  newElement = doc.createElementNS(namespaceURI, qualifiedName);
  elementName = newElement.getTagName();
  assertEquals(qualifiedName, elementName, "throw_Equals");
 }
}