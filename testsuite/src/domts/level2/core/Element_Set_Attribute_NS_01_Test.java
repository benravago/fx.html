package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setAttributeNS adds a new attribute.
* Create a new element and add a new attribute node to it using the setAttributeNS method. 
* Check if the attribute was correctly set by invoking the getAttributeNodeNS method 
* and checking the nodeName and nodeValue of the returned nodes.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
*/
class Element_Set_Attribute_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributens01")
 void run() throws Throwable {
  Document doc;
  Element element;
  Attr attribute;
  String attrName;
  String attrValue;
  doc = (Document) load("staff", true);
  element = doc.createElementNS("http://www.w3.org/DOM", "dom:elem");
  element.setAttributeNS("http://www.w3.org/DOM/Test/setAttributeNS", "attr", "value");
  attribute = element.getAttributeNodeNS("http://www.w3.org/DOM/Test/setAttributeNS", "attr");
  attrName = attribute.getNodeName();
  attrValue = attribute.getNodeValue();
  assertEquals("attr", attrName, "elementsetattributens01_attrName");
  assertEquals("value", attrValue, "elementsetattributens01_attrValue");
 }
}