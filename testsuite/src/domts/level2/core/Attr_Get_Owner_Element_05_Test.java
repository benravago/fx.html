package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getOwnerElement()" will return the Element node this attribute is attached to 
* or null if this attribute is not in use.  
* 
* Retreive an element and its attributes.  Then remove the element and check the name of 
* the ownerElement of attribute of the attribute "street".  
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement">http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
class Attr_Get_Owner_Element_05_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/attrgetownerelement05")
 void run() throws Throwable {
  Document doc;
  Node element;
  Element ownerElement;
  Element parentElement;
  NodeList elementList;
  String ownerElementName;
  Attr attr;
  Node removedChild;
  NamedNodeMap nodeMap;
  String nullNS = null;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("*", "address");
  element = elementList.item(1);
  parentElement = (Element) element.getParentNode();
  nodeMap = element.getAttributes();
  removedChild = parentElement.removeChild(element);
  attr = (Attr) nodeMap.getNamedItemNS(nullNS, "street");
  ownerElement = attr.getOwnerElement();
  ownerElementName = ownerElement.getNodeName();
  assertEquals("address", ownerElementName, "attrgetownerelement05");
 }
}