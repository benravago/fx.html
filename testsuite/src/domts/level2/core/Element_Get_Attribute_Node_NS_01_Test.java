package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getAttributeNodeNS retrieves an Attr node by local name and namespace URI.
* Create a new element node and add 2 new attribute nodes to it that have the same 
* local name but different namespaceURIs and prefixes.  
* Retrieve an attribute using namespace and localname and check its value, name and 
* namespaceURI.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAtNodeNS</a>
*/
class Element_Get_Attribute_Node_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementgetattributenodens01")
 void run() throws Throwable {
  Document doc;
  Element element;
  Attr attribute1;
  Attr attribute2;
  Attr newAttribute1;
  Attr newAttribute2;
  Attr attribute;
  String attrValue;
  String attrName;
  String attNodeName;
  String attrLocalName;
  String attrNS;
  doc = (Document) load("staffNS", false);
  element = doc.createElementNS("namespaceURI", "root");
  attribute1 = doc.createAttributeNS("http://www.w3.org/DOM/Level2", "l2:att");
  newAttribute1 = element.setAttributeNodeNS(attribute1);
  attribute2 = doc.createAttributeNS("http://www.w3.org/DOM/Level1", "att");
  newAttribute2 = element.setAttributeNodeNS(attribute2);
  attribute = element.getAttributeNodeNS("http://www.w3.org/DOM/Level2", "att");
  attrValue = attribute.getNodeValue();
  attrName = attribute.getName();
  attNodeName = attribute.getNodeName();
  attrLocalName = attribute.getLocalName();
  attrNS = attribute.getNamespaceURI();
  assertEquals("", attrValue, "elementgetattributenodens01_attrValue");
  assertEquals("l2:att", attrName, "elementgetattributenodens01_attrName");
  assertEquals("l2:att", attNodeName, "elementgetattributenodens01_attrNodeName");
  assertEquals("att", attrLocalName, "elementgetattributenodens01_attrLocalName");
  assertEquals("http://www.w3.org/DOM/Level2", attrNS, "elementgetattributenodens01_attrNs");
 }
}