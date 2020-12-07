package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method removeNamedItemNS removes a node specified by local name and namespace 
* 
* Create a new element node and add 2 new attribute nodes to it that have the same localName
* but different namespaceURI's.  Remove the first attribute node from the namedNodeMap of the
* new element node and check to see that the second attribute still exists.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193</a>
*/
class NamedNode_Map_Remove_NamedItem_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapremovenameditemns03")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Node element;
  Attr attribute;
  Attr newAttribute;
  Attr attribute1;
  Attr attribute2;
  String nodeName;
  doc = (Document) load("staffNS", true);
  element = doc.createElementNS("http://www.w3.org/DOM/Test", "root");
  attribute1 = doc.createAttributeNS("http://www.w3.org/DOM/L1", "L1:att");
  newAttribute = ((Element) /*Node */element).setAttributeNodeNS(attribute1);
  attribute2 = doc.createAttributeNS("http://www.w3.org/DOM/L2", "L2:att");
  newAttribute = ((Element) /*Node */element).setAttributeNodeNS(attribute2);
  attributes = element.getAttributes();
  attribute = (Attr) attributes.removeNamedItemNS("http://www.w3.org/DOM/L1", "att");
  attribute = (Attr) attributes.getNamedItemNS("http://www.w3.org/DOM/L2", "att");
  nodeName = attribute.getNodeName();
  assertEquals("L2:att", nodeName, "namednodemapremovenameditemns02");
 }
}