package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getNamedItemNS retrieves a node specified by local name and namespace URI. 
* 
* Using the method getNamedItemNS, retreive an attribute node having namespaceURI=http://www.nist.gov
* and localName=domestic, from a NamedNodeMap of attribute nodes, for the second element 
* whose namespaceURI=http://www.nist.gov and localName=address.  Verify if the attr node 
* has been retreived successfully by checking its nodeName atttribute.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
*/
class NamedNode_Map_Get_NamedItem_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapgetnameditemns02")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Node element;
  Attr attribute;
  NodeList elementList;
  String attrName;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
  element = elementList.item(1);
  attributes = element.getAttributes();
  attribute = (Attr) attributes.getNamedItemNS("http://www.nist.gov", "domestic");
  attrName = attribute.getNodeName();
  assertEquals("emp:domestic", attrName, "namednodemapgetnameditemns02");
 }
}