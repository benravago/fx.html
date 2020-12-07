package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method setAttributeNodeNS adds a new attribute and raises the 
* INUSE_ATTRIBUTE_ERR exception if the newAttr is already an attribute of 
* another Element object. 
* 
* Retreive an attribute node of an existing element node.  Attempt to add it to an another
* element node.  Check if the INUSE_ATTRIBUTE_ERR exception is thrown.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
*/
class Element_Set_Attribute_Node_NS_03_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementsetattributenodens03")
 void run() throws Throwable {
  Document doc;
  Element element1;
  Element element2;
  Attr attribute;
  Attr newAttribute;
  NodeList elementList;
  String nullNS = null;
  doc = (Document) load("staffNS", true);
  elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
  element1 = (Element) elementList.item(1);
  attribute = element1.getAttributeNodeNS(nullNS, "street");
  element2 = (Element) elementList.item(2);
  {
   boolean success = false;
   try {
    newAttribute = element2.setAttributeNodeNS(attribute);
   } catch (DOMException ex) {
    success = (ex.code == DOMException.INUSE_ATTRIBUTE_ERR);
   }
   assertTrue(success, "elementsetattributenodens03");
  }
 }
}