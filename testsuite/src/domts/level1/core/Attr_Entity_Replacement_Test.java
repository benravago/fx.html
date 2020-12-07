package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getValue()" method will return the value of the
* attribute as a string.  The general entity references
* are replaced with their values.
* Retrieve the attribute named "street" from the last 
* child of of the fourth employee and examine the string 
* returned by the "getValue()" method.  The value should
* be set to "Yes" after the EntityReference is
* replaced with its value.  This test uses the  
* "getNamedItem(name)" method from the NamedNodeMap 
* interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-221662474">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-221662474</a>
*/
class Attr_Entity_Replacement_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/attrentityreplacement")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testNode;
  NamedNodeMap attributes;
  Attr streetAttr;
  String value;
  doc = (Document) load("staff", true);
  addressList = doc.getElementsByTagName("address");
  testNode = addressList.item(3);
  attributes = testNode.getAttributes();
  streetAttr = (Attr) attributes.getNamedItem("street");
  value = streetAttr.getValue();
  assertEquals("Yes", value, "streetYes");
 }
}