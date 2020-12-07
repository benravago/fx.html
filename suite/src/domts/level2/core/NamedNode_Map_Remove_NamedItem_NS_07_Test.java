package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method removeNamedItemNS removes a node using its namespaceURI and localName and 
* raises a NOT_FOUND_ERR if there is no node with the specified namespaceURI and 
* localName in this map
* 
* Retreive an attribute node from a namednodemap.  While removing it from the map specify
* an incorrect localName.  This should raise a NOT_FOUND_ERR.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193</a>
*/
class NamedNode_Map_Remove_NamedItem_NS_07_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapremovenameditemns07")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Node element;
  Attr attribute;
  NodeList elementList;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "employee");
  element = elementList.item(1);
  attributes = element.getAttributes();
  {
   boolean success = false;
   try {
    attribute = (Attr) attributes.removeNamedItemNS("http://www.nist.gov", "domestic");
   } catch (DOMException ex) {
    success = (ex.code == DOMException.NOT_FOUND_ERR);
   }
   assertTrue(success, "throw_NOT_FOUND_ERR");
  }
 }
}