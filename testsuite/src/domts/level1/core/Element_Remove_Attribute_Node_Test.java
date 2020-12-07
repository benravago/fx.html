package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeAttributeNode(oldAttr)" method returns the
* node that was removed. 
* 
* Retrieve the last child of the third employee and
* remove its "street" Attr node.  The method should  
* return the old attribute node.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D589198">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D589198</a>
*/
class Element_Remove_Attribute_Node_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementremoveattributenode")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Attr streetAttr;
  Attr removedAttr;
  String removedValue;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = (Element) elementList.item(2);
  streetAttr = testEmployee.getAttributeNode("street");
  removedAttr = testEmployee.removeAttributeNode(streetAttr);
  removedValue = removedAttr.getValue();
  assertEquals("No", removedValue, "elementRemoveAttributeNodeAssert");
 }
}