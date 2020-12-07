package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retreive the second address element node having localName=adrress.  Retreive the attributes 
* of this element into 2 nodemaps.  Create a new attribute node and add it to this element.  
* Since NamedNodeMaps are live each one should get updated, using the getNamedItemNS retreive 
* the newly created attribute from each node map.
* Verify if the attr node has been retreived successfully by checking its nodeName atttribute.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
*/
class NamedNode_Map_Get_NamedItem_NS_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapgetnameditemns06")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributesMap1;
  NamedNodeMap attributesMap2;
  Element element;
  Attr attribute;
  Attr newAttr1;
  Attr newAttribute;
  NodeList elementList;
  String attrName;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("*", "address");
  element = (Element) elementList.item(1);
  attributesMap1 = element.getAttributes();
  attributesMap2 = element.getAttributes();
  newAttr1 = doc.createAttributeNS("http://www.w3.org/DOM/L1", "street");
  newAttribute = element.setAttributeNodeNS(newAttr1);
  attribute = (Attr) attributesMap1.getNamedItemNS("http://www.w3.org/DOM/L1", "street");
  attrName = attribute.getNodeName();
  assertEquals("street", attrName, "namednodemapgetnameditemnsMap106");
  attribute = (Attr) attributesMap2.getNamedItemNS("http://www.w3.org/DOM/L1", "street");
  attrName = attribute.getNodeName();
  assertEquals("street", attrName, "namednodemapgetnameditemnsMap206");
 }
}