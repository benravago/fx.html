package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method removeNamedItemNS removes a node specified by local name and namespace 
* A removed attribute may be known to have a default value when this map contains the 
* attributes attached to an element, as returned by the attributes attribute of the Node 
* interface. If so, an attribute immediately appears containing the default value as well 
* as the corresponding namespace URI, local name, and prefix when applicable.
* 
* Retreive a default attribute node.  Remove it from the NodeMap.  Check if a new one immediately
* appears containing the default value.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class NamedNode_Map_Remove_NamedItem_NS_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapremovenameditemns02")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Node element;
  Attr attribute;
  NodeList elementList;
  String attrValue;
  String nullNS = null;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "employee");
  element = elementList.item(1);
  attributes = element.getAttributes();
  attribute = (Attr) attributes.removeNamedItemNS(nullNS, "defaultAttr");
  attribute = (Attr) attributes.getNamedItemNS(nullNS, "defaultAttr");
  attrValue = attribute.getNodeValue();
  assertNotNull(attribute, "namednodemapremovenameditemns02");
  assertEquals("defaultVal", attrValue, "namednodemapremovenameditemns02_attrValue");
 }
}