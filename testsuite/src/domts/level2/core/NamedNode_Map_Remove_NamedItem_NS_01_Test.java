package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method removeNamedItemNS removes a node specified by local name and namespace 
* 
* Retreive an attribute node and then remove from the NamedNodeMap.  Verify if the attribute
* node was actually remove from the node map.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193</a>
*/
class NamedNode_Map_Remove_NamedItem_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapremovenameditemns01")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Node element;
  Attr attribute;
  NodeList elementList;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
  element = elementList.item(1);
  attributes = element.getAttributes();
  attribute = (Attr) attributes.removeNamedItemNS("http://www.nist.gov", "domestic");
  attribute = (Attr) attributes.getNamedItemNS("http://www.nist.gov", "domestic");
  assertNull(attribute, "namednodemapremovenameditemns01");
 }
}