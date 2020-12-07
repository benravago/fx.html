package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method getNamedItemNS retrieves a node specified by local name and namespace URI. 
* 
* Retreieve the second address element and its attribute into a named node map.
* Try retreiving the street attribute from the namednodemap using the
* default namespace uri and the street attribute name.  Since the default
* namespace doesnot apply to attributes this should return null.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-getNamedItemNS</a>
*/
class NamedNode_Map_Get_NamedItem_NS_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapgetnameditemns05")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Node element;
  Attr attribute;
  NodeList elementList;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagNameNS("*", "address");
  element = elementList.item(1);
  attributes = element.getAttributes();
  attribute = (Attr) attributes.getNamedItemNS("*", "street");
  assertNull(attribute, "namednodemapgetnameditemns05");
 }
}