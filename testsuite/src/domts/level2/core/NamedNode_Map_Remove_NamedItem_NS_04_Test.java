package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method removeNamedItemNS removes a node specified by local name and namespace 
* 
* Attempt to remove the xmlns and dmstc attributes of the first element node with the localName
* employee.  Verify if the 2 attributes were successfully removed.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193</a>
*/
class NamedNode_Map_Remove_NamedItem_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapremovenameditemns04")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  Node element;
  Attr attribute;
  Attr attributeRemoved;
  NodeList elementList;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("*", "employee");
  element = elementList.item(0);
  attributes = element.getAttributes();
  attributeRemoved = (Attr) attributes.removeNamedItemNS("http://www.w3.org/2000/xmlns/", "xmlns");
  attribute = (Attr) attributes.getNamedItemNS("http://www.w3.org/2000/xmlns/", "xmlns");
  assertNull(attribute, "namednodemapremovenameditemns04_1");
  attributeRemoved = (Attr) attributes.removeNamedItemNS("http://www.w3.org/2000/xmlns/", "dmstc");
  attribute = (Attr) attributes.getNamedItemNS("http://www.w3.org/2000/xmlns/", "dmstc");
  assertNull(attribute, "namednodemapremovenameditemns04_2");
 }
}