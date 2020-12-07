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
* Retreive an attribute node from a namednodemap.  Remove the attribute node from the document
* object.  Since NamedNodeMaps are live it should also automatically get removed from 
* the node map.  And so if an attempt is made to remove it using removeAttributeNS, this should 
* raise a NOT_FOUND_ERR.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193</a>
*/
class NamedNode_Map_Remove_NamedItem_NS_08_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapremovenameditemns08")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Element element;
  Attr attribute;
  NodeList elementList;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
  element = (Element) elementList.item(1);
  attributes = element.getAttributes();
  element.removeAttributeNS("http://www.nist.gov", "domestic");
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