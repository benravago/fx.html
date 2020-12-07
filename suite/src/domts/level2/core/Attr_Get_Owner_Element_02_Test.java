package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getOwnerElement()" will return the Element node this attribute
* is attached to or null if this attribute is not in use.  
* 
* Create a new element and attribute node, attach the attribute to the element.
* Check the value of owner element of the new attribute node
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement">http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement</a>
*/
class Attr_Get_Owner_Element_02_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/attrgetownerelement02")
 void run() throws Throwable {
  Document doc;
  Element element;
  Element ownerElement;
  String ownerElementName;
  Attr attr;
  Attr newAttr;
  doc = (Document) load("staffNS", false);
  element = doc.createElement("root");
  attr = doc.createAttributeNS("http://www.w3.org/DOM/L1", "L1:att");
  newAttr = element.setAttributeNodeNS(attr);
  ownerElement = attr.getOwnerElement();
  ownerElementName = ownerElement.getNodeName();
  assertTrue(equalsIgnoreCase("root", ownerElementName), "attrgetownerelement02");
 }
}