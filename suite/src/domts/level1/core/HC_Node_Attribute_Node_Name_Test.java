package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* Retrieve the Attribute named "title" from the last 
* child of the first p element and check the string returned 
* by the "getNodeName()" method.   It should be equal to 
* "title". 
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-F68D095</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=236">http://www.w3.org/Bugs/Public/show_bug.cgi?id=236</a>
*/
class HC_Node_Attribute_Node_Name_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeattributenodename")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  Attr addrAttr;
  String attrName;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("acronym");
  testAddr = (Element) elementList.item(0);
  addrAttr = testAddr.getAttributeNode("title");
  attrName = addrAttr.getNodeName();
  assertTrue(equalsAutoCase("attribute", "title", attrName), "nodeName");
 }
}