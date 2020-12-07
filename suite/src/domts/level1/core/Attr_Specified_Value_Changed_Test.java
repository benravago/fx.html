package domts.level1.core;
import org.w3c.dom.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
* The "getSpecified()" method for an Attr node should return true if the 
* value of the attribute is changed. 
* Retrieve the attribute named "street" from the last 
* child of of the THIRD employee and change its 
* value to "Yes"(which is the default DTD value).  This
* should cause the "getSpecified()" method to be true.
* This test uses the "setAttribute(name,value)" method
* from the Element interface and the "getNamedItem(name)"
* method from the NamedNodeMap interface.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-862529273">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-862529273</a>
*/
class Attr_Specified_Value_Changed_Test extends domts.DOMTestCase {
 @BeforeEach
 void setup() {
  // check if loaded documents are supported for content type
  String contentType = getContentType();
  preload(contentType, "staff", true);
 }
 @Test
 @DisplayName("http://www.w3.org/2001/DOM_Test_Suite/level1/core/attrspecifiedvaluechanged")
 void run() throws Throwable {
  Document doc;
  NodeList addressList;
  Node testNode;
  NamedNodeMap attributes;
  Attr streetAttr;
  boolean state;
  doc = (Document) load("staff", true);
  addressList = doc.getElementsByTagName("address");
  testNode = addressList.item(2);
  ((Element) /*Node */testNode).setAttribute("street", "Yes");
  attributes = testNode.getAttributes();
  streetAttr = (Attr) attributes.getNamedItem("street");
  state = streetAttr.getSpecified();
  assertTrue(state, "streetSpecified");
 }
}