package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getNamedItemNS retrieves a node specified by local name and namespace URI. 
* 
* Retreive the second address element node having localName=adrress.
* Create a new attribute node having the same name as an existing node but different namespaceURI
* and add it to this element.  Using the getNamedItemNS retreive the newly created attribute 
* node from a nodemap of attributes of the retreive element node.
* Verify if the attr node has been retreived successfully by checking its nodeName atttribute.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
*/
class NamedNode_Map_Get_NamedItem_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapgetnameditemns04")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Element element;
  Attr attribute;
  Attr newAttr1;
  Attr newAttribute;
  NodeList elementList;
  String attrName;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("*", "address");
  element = (Element) elementList.item(1);
  newAttr1 = doc.createAttributeNS("http://www.w3.org/DOM/L1", "street");
  newAttribute = element.setAttributeNodeNS(newAttr1);
  attributes = element.getAttributes();
  attribute = (Attr) attributes.getNamedItemNS("http://www.w3.org/DOM/L1", "street");
  attrName = attribute.getNodeName();
  assertEquals("street", attrName, "namednodemapgetnameditemns04");
 }
}