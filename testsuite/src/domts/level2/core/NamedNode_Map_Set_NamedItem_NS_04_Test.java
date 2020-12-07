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
* Create a new document and a new attribute node in it.  Call the setNamedItemNS using the first 
* namedNodeMap and the new attribute node attribute of the new document.  This should
* raise a WRONG_DOCUMENT_ERR. 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class NamedNode_Map_Set_NamedItem_NS_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/namednodemapsetnameditemns04")
 void run() throws Throwable {
  Document doc;
  DOMImplementation domImpl;
  Document docAlt;
  DocumentType docType = null;
  NamedNodeMap attributes;
  NodeList elementList;
  Element element;
  Attr attrAlt;
  Node newNode;
  String nullNS = null;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("*", "address");
  element = (Element) elementList.item(1);
  attributes = element.getAttributes();
  domImpl = doc.getImplementation();
  docAlt = domImpl.createDocument(nullNS, "newDoc", docType);
  attrAlt = docAlt.createAttributeNS(nullNS, "street");
  {
   boolean success = false;
   try {
    newNode = attributes.setNamedItemNS(attrAlt);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.WRONG_DOCUMENT_ERR);
   }
   assertTrue(success, "throw_WRONG_DOCUMENT_ERR");
  }
 }
}