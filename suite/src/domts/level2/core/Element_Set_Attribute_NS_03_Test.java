package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setAttributeNS adds a new attribute.
* Retreive an existing element node with a default attribute node and 
* add two new attribute nodes that have the same local name as the 
* default attribute but different namespaceURI to it using the setAttributeNS method.   
* Check if the attribute was correctly set by invoking the getAttributeNodeNS method
* and checking the nodeName and nodeValue of the returned nodes.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
*/
class Element_Set_Attribute_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributens03")
 void run() throws Throwable {
  Document doc;
  Element element;
  Attr attribute;
  NodeList elementList;
  String attrName;
  String attrValue;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("emp:employee");
  element = (Element) elementList.item(0);
  assertNotNull(element, "empEmployeeNotNull");
  element.setAttributeNS("http://www.w3.org/DOM/Test/1", "defaultAttr", "default1");
  element.setAttributeNS("http://www.w3.org/DOM/Test/2", "defaultAttr", "default2");
  attribute = element.getAttributeNodeNS("http://www.w3.org/DOM/Test/1", "defaultAttr");
  attrName = attribute.getNodeName();
  attrValue = attribute.getNodeValue();
  assertEquals("defaultAttr", attrName, "elementsetattributens03_attrName");
  assertEquals("default1", attrValue, "elementsetattributens03_attrValue");
 }
}