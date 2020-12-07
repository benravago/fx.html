package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getNamedItemNS retrieves a node specified by local name and namespace URI. 
* 
* Create a new Element node and add 2 new attribute nodes having the same local name but different
* namespace names and namespace prefixes to it.  Using the getNamedItemNS retreive the second attribute node.  
* Verify if the attr node has been retreived successfully by checking its nodeName atttribute.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
*/
class NamedNode_Map_Get_NamedItem_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapgetnameditemns03")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Node element;
  Attr attribute;
  Attr newAttr1;
  Attr newAttr2;
  Attr newAttribute;
  String attrName;
  doc = (Document) load("staffNS", false);
  element = doc.createElementNS("http://www.w3.org/DOM/Test", "root");
  newAttr1 = doc.createAttributeNS("http://www.w3.org/DOM/L1", "L1:att");
  newAttribute = ((Element) /*Node */element).setAttributeNodeNS(newAttr1);
  newAttr2 = doc.createAttributeNS("http://www.w3.org/DOM/L2", "L2:att");
  newAttribute = ((Element) /*Node */element).setAttributeNodeNS(newAttr2);
  attributes = element.getAttributes();
  attribute = (Attr) attributes.getNamedItemNS("http://www.w3.org/DOM/L2", "att");
  attrName = attribute.getNodeName();
  assertEquals("L2:att", attrName, "namednodemapgetnameditemns03");
 }
}