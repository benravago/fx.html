package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setPrefix sets the namespace prefix of this node.  Note that setting this attribute, 
* when permitted, changes the nodeName attribute, which holds the qualified name, as well as the 
* tagName and name attributes of the Element and Attr interfaces, when applicable.
* Create a new attribute node and add it to an element node with an existing attribute having
* the same localName as this attribute but different namespaceURI.  Change the prefix of the
* newly created attribute using setPrefix.  Check if the new attribute nodeName has changed
* and the existing attribute is the same.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
*/
class Node_Set_Prefix_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/nodesetprefix02")
 void run() throws Throwable {
  Document doc;
  Element element;
  Attr attribute;
  Attr newAttribute;
  Node setNode;
  NodeList elementList;
  String attrName;
  String newAttrName;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagName("address");
  element = (Element) elementList.item(1);
  newAttribute = doc.createAttributeNS("http://www.w3.org/DOM/Test", "test:address");
  setNode = element.setAttributeNodeNS(newAttribute);
  newAttribute.setPrefix("dom");
  attribute = element.getAttributeNodeNS("http://www.usa.com", "domestic");
  attrName = attribute.getNodeName();
  newAttrName = newAttribute.getNodeName();
  assertEquals("dmstc:domestic", attrName, "nodesetprefix02_attrName");
  assertEquals("dom:address", newAttrName, "nodesetprefix02_newAttrName");
 }
}