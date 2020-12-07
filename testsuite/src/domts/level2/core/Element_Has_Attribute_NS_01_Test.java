package domts.level2.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The method hasAttributeNS returns true when an attribute with a given local name 
* and namespace 
* URI is specified on this element or has a default value, false otherwise. 
* 
* Retreive the first employee element node.  Invoke the hasAttributeNS method to check if it 
* has the xmlns attribute that belongs to the namespace http://www.w3.org/2000/xmlns/.
* 
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElHasAttrNS</a>
*/
class Element_Has_Attribute_NS_01_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setNamespaceAware(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staffNS", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level2/core/elementhasattributens01")
 void run() throws Throwable {
  Document doc;
  Element element;
  boolean state;
  NodeList elementList;
  doc = (Document) load("staffNS", false);
  elementList = doc.getElementsByTagNameNS("*", "employee");
  element = (Element) elementList.item(0);
  state = element.hasAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns");
  assertTrue(state, "elementhasattributens01");
 }
}