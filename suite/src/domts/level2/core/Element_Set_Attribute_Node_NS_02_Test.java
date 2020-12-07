package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Test the setAttributeNodeNS method.
* Retreive the street attribute from the second address element node.  
* Clone it and add it to the first address node.  The INUSE_ATTRIBUTE_ERR exception
* should not be thrown. Check the name and value of the newly added node.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class Element_Set_Attribute_Node_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributenodens02")
 void run() throws Throwable {
  Document doc;
  Element element;
  Element element2;
  Attr attribute;
  Attr attributeCloned;
  Attr newAttr;
  NodeList elementList;
  String attrName;
  String attrValue;
  String nullNS = null;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
  element = (Element) elementList.item(1);
  attribute = element.getAttributeNodeNS(nullNS, "street");
  attributeCloned = (Attr) attribute.cloneNode(true);
  element2 = (Element) elementList.item(2);
  newAttr = element2.setAttributeNodeNS(attributeCloned);
  attrName = newAttr.getNodeName();
  attrValue = newAttr.getNodeValue();
  assertEquals("street", attrName, "elementsetattributenodens02_attrName");
  assertEquals("Yes", attrValue, "elementsetattributenodens02_attrValue");
 }
}