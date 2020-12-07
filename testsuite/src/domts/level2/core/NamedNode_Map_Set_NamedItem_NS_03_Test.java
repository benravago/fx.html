package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setNamedItemNS adds a node using its namespaceURI and localName and 
* raises a WRONG_DOCUMENT_ERR if arg was created from a different document than the 
* one that created this map.
* 
* Retreieve the second element whose local name is address and its attribute into a named node map.
* Do the same for another document and retreive its street attribute.  Call the setNamedItemNS
* using the first namedNodeMap and the retreive street attribute of the second.  This should
* raise a WRONG_DOCUMENT_ERR. 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=408">http://www.w3.org/Bugs/Public/show_bug.cgi?id=408</a>
*/
class NamedNode_Map_Set_NamedItem_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapsetnameditemns03")
 void run() throws Throwable {
  Document doc;
  Document docAlt;
  NamedNodeMap attributes;
  NamedNodeMap attributesAlt;
  NodeList elementList;
  NodeList elementListAlt;
  Element element;
  Element elementAlt;
  Attr attr;
  Node newNode;
  String nullNS = null;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("*", "address");
  element = (Element) elementList.item(1);
  attributes = element.getAttributes();
  docAlt = (Document) load("staffNS", true);
  elementListAlt = docAlt.getElementsByTagNameNS("*", "address");
  elementAlt = (Element) elementListAlt.item(1);
  attributesAlt = elementAlt.getAttributes();
  attr = (Attr) attributesAlt.getNamedItemNS(nullNS, "street");
  newNode = attributesAlt.removeNamedItemNS(nullNS, "street");
  {
   boolean success = false;
   try {
    newNode = attributes.setNamedItemNS(attr);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.WRONG_DOCUMENT_ERR);
   }
   assertTrue(success, "throw_WRONG_DOCUMENT_ERR");
  }
 }
}