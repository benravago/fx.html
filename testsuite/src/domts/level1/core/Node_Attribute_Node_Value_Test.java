package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The string returned by the "getNodeValue()" method for an 
* Attribute Node is the value of the Attribute.
* 
* Retrieve the Attribute named "domestic" from the last 
* child of the first employee and check the string returned 
* by the "getNodeValue()" method.   It should be equal to 
* "Yes". 
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D080</a>
*/
class Node_Attribute_Node_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/nodeattributenodevalue")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  Attr addrAttr;
  String attrValue;
  doc = (Document) load("staff", false);
  elementList = doc.getElementsByTagName("address");
  testAddr = (Element) elementList.item(0);
  addrAttr = testAddr.getAttributeNode("domestic");
  attrValue = addrAttr.getNodeValue();
  assertEquals("Yes", attrValue, "nodeAttributeNodeValueAssert1");
 }
}