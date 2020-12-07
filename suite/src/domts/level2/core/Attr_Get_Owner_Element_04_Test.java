package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getOwnerElement()" will return the Element node this attribute is attached to or 
* null if this attribute is not in use.  
* Import an attribute node to another document.  If an Attr node is imported, its 
* ownerElement attribute should be set to null.  Verify if the ownerElement has been set 
* to null.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement">http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement</a>
*/
class Attr_Get_Owner_Element_04_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/attrgetownerelement04")
 void run() throws Throwable {
  Document doc;
  Document docImp;
  Node ownerElement;
  Element element;
  Attr attr;
  Attr attrImp;
  NodeList addresses;
  doc = (Document) load("staffNS", false);
  docImp = (Document) load("staff", false);
  addresses = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
  element = (Element) addresses.item(1);
  assertNotNull(element, "empAddressNotNull");
  attr = element.getAttributeNodeNS("http://www.nist.gov", "zone");
  attrImp = (Attr) docImp.importNode(attr, true);
  ownerElement = attrImp.getOwnerElement();
  assertNull(ownerElement, "attrgetownerelement04");
 }
}