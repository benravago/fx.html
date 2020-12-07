package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method createAttributeNS creates an attribute of the given qualified name and namespace URI
* 
* Invoke the createAttributeNS method on this Document object with a null 
* namespaceURI, and a qualifiedName without a prefix.  This should return a valid Attr 
* node object.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS</a>
*/
class Document_Create_Attribute_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/documentcreateattributeNS01")
 void run() throws Throwable {
  Document doc;
  Attr attribute;
  String namespaceURI = null;
  String qualifiedName = "test";
  String name;
  String nodeName;
  String nodeValue;
  doc = (Document) load("staffNS", false);
  attribute = doc.createAttributeNS(namespaceURI, qualifiedName);
  nodeName = attribute.getNodeName();
  nodeValue = attribute.getNodeValue();
  assertEquals("test", nodeName, "documentcreateattributeNS01");
 }
}