package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getOwnerElement()" will return the Element node this attribute is attached to or 
* null if this attribute is not in use.  
* 
* Retreive the default attribute defaultAttr and check its owner element.  Verify if the name
* the nodeName of the returned ownerElement is emp:employee.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement">http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class Attr_Get_Owner_Element_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/attrgetownerelement01")
 void run() throws Throwable {
  Document doc;
  Attr attr;
  Element element;
  Element ownerElement;
  String ownerElementName;
  NodeList elementList;
  NamedNodeMap attributes;
  String nullNS = null;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "employee");
  element = (Element) elementList.item(1);
  attributes = element.getAttributes();
  attr = (Attr) attributes.getNamedItemNS(nullNS, "defaultAttr");
  ownerElement = attr.getOwnerElement();
  ownerElementName = ownerElement.getNodeName();
  assertEquals("emp:employee", ownerElementName, "attrgetownerelement01");
 }
}