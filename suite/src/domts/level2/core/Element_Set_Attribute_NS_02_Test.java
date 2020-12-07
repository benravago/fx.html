package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setAttributeNS adds a new attribute.
* 
* Retrieve an existing element node with attributes and add a new attribute node to it using 
* the setAttributeNS method.   Check if the attribute was correctly set by invoking the 
* getAttributeNodeNS method and checking the nodeName and nodeValue of the returned nodes.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
*/
class Element_Set_Attribute_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributens02")
 void run() throws Throwable {
  Document doc;
  Element element;
  Attr attribute;
  NodeList elementList;
  String attrName;
  String attrValue;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagNameNS("*", "address");
  element = (Element) elementList.item(0);
  element.setAttributeNS("http://www.w3.org/DOM/Test/setAttributeNS", "this:street", "Silver Street");
  attribute = element.getAttributeNodeNS("http://www.w3.org/DOM/Test/setAttributeNS", "street");
  attrName = attribute.getNodeName();
  attrValue = attribute.getNodeValue();
  assertEquals("this:street", attrName, "elementsetattributens02_attrName");
  assertEquals("Silver Street", attrValue, "elementsetattributens02_attrValue");
 }
}