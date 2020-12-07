package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "createAttributeNS(namespaceURI,qualifiedName)" method for a 
* Document should return a new Attr object given that all parameters are
* valid and correctly formed.
* 
* Invoke method createAttributeNS(namespaceURI,qualifiedName) on this document with
* parameters equal "http://www.ecommerce.org/" and "ecom:local"
* respectively. Method should return a new Attr object whose name is "ecom:local".
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1112119403">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-1112119403</a>
*/
class Create_Attribute_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/createAttributeNS05")
 void run() throws Throwable {
  String namespaceURI = "http://www.ecommerce.org/";
  String qualifiedName = "econm:local";
  Document doc;
  Attr newAttr;
  String attrName;
  doc = (Document) load("staffNS", false);
  newAttr = doc.createAttributeNS(namespaceURI, qualifiedName);
  attrName = newAttr.getName();
  assertEquals(qualifiedName, attrName, "throw_Equals");
 }
}