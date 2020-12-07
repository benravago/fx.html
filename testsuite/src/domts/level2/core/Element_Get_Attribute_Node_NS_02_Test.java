package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getAttributeNodeNS retrieves an Attr node by local name and namespace URI.  
* Create a new element node and add a new attribute node to it.  Using the getAttributeNodeNS,
* retrieve the newly added attribute node and check its value.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAtNodeNS</a>
*/
class Element_Get_Attribute_Node_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementgetattributenodens02")
 void run() throws Throwable {
  Document doc;
  Element element;
  Attr attribute;
  Attr newAttribute1;
  String attrValue;
  doc = (Document) load("staffNS", false);
  element = doc.createElementNS("namespaceURI", "root");
  attribute = doc.createAttributeNS("http://www.w3.org/DOM/Level2", "l2:att");
  newAttribute1 = element.setAttributeNodeNS(attribute);
  attribute = element.getAttributeNodeNS("http://www.w3.org/DOM/Level2", "att");
  attrValue = attribute.getNodeValue();
  assertEquals("", attrValue, "elementgetattributenodens02");
 }
}