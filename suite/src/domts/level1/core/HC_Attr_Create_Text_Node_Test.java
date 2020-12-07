package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "setValue()" method for an attribute creates a 
* Text node with the unparsed content of the string.
* Retrieve the attribute named "class" from the last 
* child of of the fourth employee and assign the "Y&ent1;" 
* string to its value attribute.  This value is not yet
* parsed and therefore should still be the same upon
* retrieval. This test uses the "getNamedItem(name)" method
* from the NamedNodeMap interface.  
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-221662474">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-221662474</a>
* @see <a href="http://lists.w3.org/Archives/Public/www-dom-ts/2002Apr/0057.html">http://lists.w3.org/Archives/Public/www-dom-ts/2002Apr/0057.html</a>
*/
class HC_Attr_Create_Text_Node_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "hc_staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/hc_attrcreatetextnode")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testNode;
  NamedNodeMap attributes;
  Attr streetAttr;
  String value;
  doc = (Document) load("hc_staff", true);
  addressList = doc.getElementsByTagName("acronym");
  testNode = addressList.item(3);
  attributes = testNode.getAttributes();
  streetAttr = (Attr) attributes.getNamedItem("class");
  streetAttr.setValue("Y&ent1;");
  value = streetAttr.getValue();
  assertEquals("Y&ent1;", value, "value");
  value = streetAttr.getNodeValue();
  assertEquals("Y&ent1;", value, "nodeValue");
 }
}