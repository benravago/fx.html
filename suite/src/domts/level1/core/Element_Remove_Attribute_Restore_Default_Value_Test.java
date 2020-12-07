package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "removeAttributeNode(oldAttr)" method removes the
* specified attribute node and restores any default values. 
* 
* Retrieve the last child of the third employeed and 
* remove its "street" Attr node.  Since this node has a
* default value defined in the DTD file, that default
* should immediately be the new value.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D589198">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-D589198</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html">http://lists.w3.org/Archives/Public/www-dom-ts/2002Mar/0002.html</a>
*/
@Disabled("fx")
class Element_Remove_Attribute_Restore_Default_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  setValidating(true);
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/elementremoveattributerestoredefaultvalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testEmployee;
  Attr streetAttr;
  String attribute;
  Attr removedAttr;
  doc = (Document) load("staff", true);
  elementList = doc.getElementsByTagName("address");
  testEmployee = (Element) elementList.item(2);
  streetAttr = testEmployee.getAttributeNode("street");
  removedAttr = testEmployee.removeAttributeNode(streetAttr);
  attribute = testEmployee.getAttribute("street");
  assertEquals("Yes", attribute, "streetYes");
 }
}