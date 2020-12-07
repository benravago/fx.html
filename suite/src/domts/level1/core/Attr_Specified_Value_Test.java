package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getSpecified()" method for an Attr node should 
* be set to true if the attribute was explicitly given
* a value.
* Retrieve the attribute named "domestic" from the last 
* child of of the first employee and examine the value 
* returned by the "getSpecified()" method.  This test uses 
* the "getNamedItem(name)" method from the NamedNodeMap 
* interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-862529273">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-862529273</a>
*/
class Attr_Specified_Value_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", false);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/attrspecifiedvalue")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testNode;
  NamedNodeMap attributes;
  Attr domesticAttr;
  boolean state;
  doc = (Document) load("staff", false);
  addressList = doc.getElementsByTagName("address");
  testNode = addressList.item(0);
  attributes = testNode.getAttributes();
  domesticAttr = (Attr) attributes.getNamedItem("domestic");
  state = domesticAttr.getSpecified();
  assertTrue(state, "domesticSpecified");
 }
}