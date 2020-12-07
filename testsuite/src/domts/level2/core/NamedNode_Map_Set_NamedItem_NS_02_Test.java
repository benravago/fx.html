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
* Create a new element and attribute Node and add the newly created attribute node to the elements 
* NamedNodeMap.  Verify if the new attr node has been successfully added to the map by checking 
* the nodeName of the retreived atttribute from the list of attribute nodes in this map.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
*/
class NamedNode_Map_Set_NamedItem_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapsetnameditemns02")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Element element;
  Attr attribute;
  Attr attribute1;
  Node newNode;
  String attrName;
  doc = (Document) load("staffNS", true);
  element = doc.createElementNS("http://www.w3.org/DOM/Test", "root");
  attribute1 = doc.createAttributeNS("http://www.w3.org/DOM/L1", "L1:att");
  attributes = element.getAttributes();
  newNode = attributes.setNamedItemNS(attribute1);
  attribute = (Attr) attributes.getNamedItemNS("http://www.w3.org/DOM/L1", "att");
  attrName = attribute.getNodeName();
  assertEquals("L1:att", attrName, "namednodemapsetnameditemns02");
 }
}