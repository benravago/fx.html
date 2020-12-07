package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setNamedItemNS adds a node using its namespaceURI and localName. If a node with 
* that namespace URI and that local name is already present in this map, it is replaced 
* by the new one.
* 
* Retreive the first element whose localName is address and namespaceURI http://www.nist.gov", 
* and put its attributes into a named node map.  Create a new attribute node and add it to this map.  
* Verify if the attr node was successfully added by checking the nodeName of the retreived atttribute.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
*/
class NamedNode_Map_Set_NamedItem_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapsetnameditemns01")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Node element;
  Attr attribute;
  Attr newAttribute;
  Attr newAttr1;
  NodeList elementList;
  String attrName;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
  element = elementList.item(0);
  attributes = element.getAttributes();
  newAttr1 = doc.createAttributeNS("http://www.w3.org/DOM/L1", "streets");
  newAttribute = ((Element) /*Node */element).setAttributeNodeNS(newAttr1);
  attribute = (Attr) attributes.getNamedItemNS("http://www.w3.org/DOM/L1", "streets");
  attrName = attribute.getNodeName();
  assertEquals("streets", attrName, "namednodemapsetnameditemns01");
 }
}