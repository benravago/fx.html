package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Testing Element.setAttributeNodeNS: If an attribute with that local name 
* and that namespace URI is already present in the element, it is replaced
* by the new one.
* Create a new element and two new attribute nodes (in the same namespace
* and same localNames).  
* Add the two new attribute nodes to the element node using the 
* setAttributeNodeNS method.  Check that only one attribute is added, check
* the value of this attribute.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
*/
class Element_Set_Attribute_Node_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributenodens01")
 void run() throws Throwable {
  Document doc;
  Element element;
  Attr attribute1;
  Attr attribute2;
  Attr attrNode;
  String attrName;
  String attrNS;
  String attrValue;
  NamedNodeMap attributes;
  Attr newAttribute;
  int length;
  doc = (Document) load("staff", true);
  element = doc.createElementNS("http://www.w3.org/DOM/Test/Level2", "new:element");
  attribute1 = doc.createAttributeNS("http://www.w3.org/DOM/Test/att1", "p1:att");
  attribute2 = doc.createAttributeNS("http://www.w3.org/DOM/Test/att1", "p2:att");
  attribute2.setValue("value2");
  newAttribute = element.setAttributeNodeNS(attribute1);
  newAttribute = element.setAttributeNodeNS(attribute2);
  attrNode = element.getAttributeNodeNS("http://www.w3.org/DOM/Test/att1", "att");
  attrName = attrNode.getNodeName();
  attrNS = attrNode.getNamespaceURI();
  assertEquals("p2:att", attrName, "elementsetattributenodens01_attrName");
  assertEquals("http://www.w3.org/DOM/Test/att1", attrNS, "elementsetattributenodens01_attrNS");
  attributes = element.getAttributes();
  length = (int) attributes.getLength();
  assertEquals(1, length, "length");
 }
}