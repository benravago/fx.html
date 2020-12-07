package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getNodeType()" method for an Attribute Node
* returns the constant value 2.
* 
* Retrieve the first attribute from the last child of
* the first employee and invoke the "getNodeType()"   
* method.   The method should return 2. 
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-111237558</a>
*/
class HC_Node_Attribute_Node_Type_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_nodeattributenodetype")
 void run() throws Throwable {
  Document doc;
  NodeList elementList;
  Element testAddr;
  Attr addrAttr;
  int nodeType;
  doc = (Document) load("hc_staff", false);
  elementList = doc.getElementsByTagName("acronym");
  testAddr = (Element) elementList.item(0);
  addrAttr = testAddr.getAttributeNode("title");
  nodeType = (int) addrAttr.getNodeType();
  assertEquals(2, nodeType, "nodeAttrNodeTypeAssert1");
 }
}