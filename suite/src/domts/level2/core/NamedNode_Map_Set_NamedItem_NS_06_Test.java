package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retreieve the first element whose localName is address and its attributes into a named node map.
* Retreiving the domestic attribute from the namednodemap.  
* Retreieve the second element whose localName is address and its attributes into a named node map.
* Invoke setNamedItemNS on the second NamedNodeMap specifying the first domestic attribute from
* the first map.  This should raise an INUSE_ATTRIBIUTE_ERR.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
*/
class NamedNode_Map_Set_NamedItem_NS_06_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapsetnameditemns06")
 void run() throws Throwable {
  Document doc;
  NamedNodeMap attributes;
  NodeList elementList;
  Element element;
  Attr attr;
  Node newNode;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("*", "address");
  element = (Element) elementList.item(0);
  attributes = element.getAttributes();
  attr = (Attr) attributes.getNamedItemNS("http://www.usa.com", "domestic");
  element = (Element) elementList.item(1);
  attributes = element.getAttributes();
  {
   boolean success = false;
   try {
    newNode = attributes.setNamedItemNS(attr);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INUSE_ATTRIBUTE_ERR);
   }
   assertTrue(success, "namednodemapsetnameditemns06");
  }
 }
}